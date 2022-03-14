package ACWing.动态规划.背包问题.分组背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :
 * @Author : LeafTalk
 * @Data : 2022/2/21
 */
public class Demo01 {
    static int N = 110;
    static int n; //n组物品
    static int m; //背包容量
    static int[] count = new int[N];  //每组物品的个数
    static int[][] v = new int[N][N]; //第i组第j个物品体积
    static int[][] w = new int[N][N]; //第i组第j个物品价值
    static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for(int i=1;i<=n;i++){
            count[i] = Integer.parseInt(br.readLine());
            for (int j = 1; j <= count[i]; j++) {
                String[] str02 = br.readLine().split(" ");
                v[i][j] = Integer.parseInt(str02[0]);
                w[i][j] = Integer.parseInt(str02[1]);
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=m;j>=0;j--){
                for(int k=1;k<=count[i];k++){
                    if(j>=v[i][k]){
                        p[j] = Math.max(p[j],p[j-v[i][k]]+w[i][k]);
                    }

                }
            }
        }
        System.out.println(p[m]);
    }
}
