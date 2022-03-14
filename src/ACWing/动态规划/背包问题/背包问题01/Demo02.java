package ACWing.动态规划.背包问题.背包问题01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :01背包问题 （一维数组优化）
 * @Author : LeafTalk
 * @Data : 2022/2/9
 */
public class Demo02 {
    static int N = 1010;
    static int n,m;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] p = new int[N];

    //一维数组优化：时间复杂度o(nm)
    //二位数组做法：p[i][j] = max( p[i-1][j], p[i-1][j-v[i]] + w[i] );其中i只与i-1有关，所以可以使用滚动数组 思想来优化，去掉一维
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

        for (int i = 1; i <= n; i++) {
            //注意此处j从大到小逆向循环，为了防止上一层的p[0~j-1]被先更新了
            // 当j从v[i]开始更新时，先跟新p[5]=5，当更新到p[10]时，p[10]=max(p[10], p[10-5])=max(p[10],p[5])此时p[5]已经是第i层的p[5],第i件物品被选择了两次了
            //与原状态方程 p[i][j] = max(p[i-1][j], p[i-1][j-v]+w) 将i-1层更新到i层相违背
            //所以得从大到小进行更新，p[10]=max(p[10],p[5])此时p[5]还是i-1层的p[5]
            for(int j=m;j>=v[i];j--){
                p[j] = Math.max(p[j],p[j-v[i]]+w[i]);
            }
        }
        System.out.println(p[m]);

    }
}
