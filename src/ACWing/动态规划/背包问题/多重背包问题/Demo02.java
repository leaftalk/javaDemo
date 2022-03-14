package ACWing.动态规划.背包问题.多重背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :多重背包问题II
 *  N个物品，背包容量V                          N ∈ [1,1000] V ∈ [1,2000]
 *  第i件物品最多有si件，每件体积vi，价值wi        si,vi,wi∈[1,2000]
 * @Author : LeafTalk
 * @Data : 2022/2/14
 */
public class Demo02 {
    static int N = 12010;
    static int M = 2010;
    static int n; //n个物品
    static int V; // 背包容量
    static int[] v = new int[N]; //每个物品体积
    static int[] w = new int[N]; //每个物品价格
    static int[] p = new int[M];

    //暴力做法时间复杂度o(n^3) 1000*2000*2000=4,000,000,000 TLE了
    //二进制优化做法 时间复杂度o(n^2*logn) 1000*2000*log2000 = 12*2,000,000 = 24,000,000
    //思路： 每件物品有si件,二进制表示为 si=1+2+4，。。。+log(si)+c件物品，则0~si之间每个数都可以用（1，2，4...log(si),c）取其中某几个相加得到
    //原思路是 枚举第i个物品，从0~si个,每个第i件i物品都可以选或不选，这样i物品就有si个选法，
    //二进制优化思路：将（1，2，4,...log(si)）分别打包成新的物品，每件新物品都只有0/1两种状态，以组成原来i物品选si个的情况
    // 转化为 log(s1)+log(s2)+log(s3)...log(si)件物品，每件都分为选或不选，转化为0/1背包问题
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        V = Integer.parseInt(str[1]); //背包容量

        int cnt =0;
        for (int i = 1; i <= n; i++) {
            String[] str02 = br.readLine().split(" ");
            int vi = Integer.parseInt(str02[0]);
            int wi = Integer.parseInt(str02[1]);
            int si =  Integer.parseInt(str02[2]);
            int k =1;
            while(k<=si){
                cnt++;
                v[cnt] = k * vi;
                w[cnt] = k * wi;
                si -= k;
                k = k*2;
            }
            if(si>0){
                cnt++;
                v[cnt] = si * vi;
                w[cnt] = si * wi;
            }

        }
        n =cnt;
        for(int i=1;i<=n;i++){
            for(int j=V;j>=v[i];j--){
                p[j] = Math.max(p[j], p[j-v[i]]+w[i]);
            }
        }
        System.out.println(p[V]);
    }
}
