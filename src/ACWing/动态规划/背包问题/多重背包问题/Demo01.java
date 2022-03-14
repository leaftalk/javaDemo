package ACWing.动态规划.背包问题.多重背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :多重背包问题 I
 * N个物品，背包容量V                          N,V ∈ [1,100]
 * 第i件物品最多有si件，每件体积vi，价值wi        si,vi,wi∈[1,100]
 * @Author : LeafTalk
 * @Data : 2022/2/14
 */
public class Demo01 {
    static int N = 110;
    static int n; //n个物品
    static int V; // 背包容量
    static int[] v = new int[N]; //每个物品体积
    static int[] s = new int[N]; // 每个物品个数
    static int[] w = new int[N]; //每个物品价格
    static int[][] p = new int[N][N];

    //朴素做法  状态计算 同 完全背包问题
    // 时间复杂度 o(n^3) 1,000,000
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            V = Integer.parseInt(str[1]); //背包容量

            for (int i = 1; i <= n; i++) {
                String[] str02 = br.readLine().split(" ");
                v[i] = Integer.parseInt(str02[0]);
                w[i] = Integer.parseInt(str02[1]);
                s[i] =  Integer.parseInt(str02[2]);
            }
            for(int i=1;i<=n;i++){
                for(int j=0;j<=V;j++){
                    for(int k=0; k<=s[i] && k*v[i] <=j ;k++){
                        p[i][j] = Math.max( p[i][j], p[i-1][j-k*v[i]] + w[i]*k );
                    }
                }
            }
        System.out.println(p[n][V]);
    }
}
