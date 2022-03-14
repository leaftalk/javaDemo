package ACWing.动态规划.背包问题.背包问题01;

import java.io.*;

/**
 * @Description :01背包问题
 * @Author : LeafTalk
 * @Data : 2022/2/9
 */
public class Demo01 {
    static int N = 1010;
    static int n,m;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[][] p = new int[N][N];

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

        //朴素做法：时间复杂度o(2^n) n件物品，每件物品都有0/1两个状态
        // 状态表示： p[i][j]:从i个物品中选 ，体积不超过j的物品个数， 属性： 总价值最大
        //状态计算： p[i][j] = 分为 包含第i个 或者 不包含第i个
        // 包含第i个： p[i-1][j-v[i]] + w[i] （先去掉第i个，从i-1个当中选体积不超过 j-v[i]，然后再加上w[i] ）
        // 不包含i: p[i][j] = p[i-1][j] （从i-1个当中选体积不超过j）
        // p[i][j] = max( p[i-1][j], p[i-1][j-v[i]] + w[i] );
         for (int i = 1; i <= n; i++) {
            for(int j=0;j<=m;j++){
                p[i][j] = p[i-1][j];
                if(j >= v[i]){
                    p[i][j] = Math.max(p[i][j],p[i-1][j-v[i]]+w[i]);
                }
            }
        }

        System.out.println(p[n][m]);

    }
}
