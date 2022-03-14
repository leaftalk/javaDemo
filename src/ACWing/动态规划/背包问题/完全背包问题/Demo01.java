package ACWing.动态规划.背包问题.完全背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *                            为什么完全背包问题优化后，与01背包问题只是顺序循环与逆序循环的区别（用第i-1行还是第i行来更新第i行问题）
 * 背包九讲：https://www.cnblogs.com/jbelial/articles/2116074.html
 *  优质题解： https://www.acwing.com/solution/content/3986/
 * @Description : 完全背包问题
 * @Author : LeafTalk
 * @Data : 2022/2/10
 */
public class Demo01 {
    static int N = 1010;
    static int n, m;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[][] p = new int[N][N];
    static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for (int i = 1; i <= n; i++) {
            String[] str02 = br.readLine().split(" ");
            v[i] = Integer.parseInt(str02[0]);
            w[i] = Integer.parseInt(str02[1]);
        }

        function01();
        System.out.println(p[n][m]);
    }

    //朴素做法 时间复杂度 O(nm*max(m/v[i]))
    //p[i][j] 计算的是前 i 个物品 j 体积的最优解f[i][j] ，
    // 而前 i−1 个物品的最优解 f[i−1][j] 在上一轮循环中都已计算完毕，
    // 现在我们只需判断选择几个第 i 种物品得到的价值最大。
    public static void function01() {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k * v[i] <= j; k++) {
                    p[i][j] = Math.max(p[i][j], p[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
    }

    //优化做法：时间复杂度 o(nm)
    //优化思路：此优化思路是在0/1背包问题基础上来优化的，0/1背包问题中 j从m~v[i],逆序循环，这是为了保证第i次循环时的状态f[i][j]是由f[i-1][j-v]更新而来的，
    //换句话说正是为了保证每件物品只选一次，而完全背包问题恰好每件物品可以选多次，所以j从0~m开始循环
    //当j=v[i],  p[i][v[i]] = max(p[i][0]+w[i],p[i][v[i]]); 物品i被选择了一次
    // j=2v[i], p[i][2v[i]] = max(p[i][v[i]]+w[i],p[i][2v[i]])；物品i被选择了两次
    // j=3v[i], p[i][3v[i]] = max(p[i][2v[i]]+w[i],p[i][3v[i]]);物品i被选择了三次
    //  。。。。。。
    //p[i][j] = Max( p[i-1][j], p[i-1][j-v]+w , p[i-1][j-2v]+2w, p[i-1][j-3v]+3w....p[i-1][j-kv]+kw)
    //p[i][j-v] = Max(          p[i-1][j-v]    ,p[i-1][j-2v]+w , p[i-1][j-3v]+2w....)
    // p[i][j] = Max( p[i-1][j], p[i][j-v]+w)
    public static void function02() {
        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j <= m; j++) {
                    //选择第i个物品
                    p[i][j] = Math.max(p[i][j], p[i][j - v[i]] + w[i]);
            }
        }
    }

    //一维优化
    public static void function03() {
        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j <= m; j++) {
                    f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
    }
}
