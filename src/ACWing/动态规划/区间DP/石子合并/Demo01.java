package ACWing.动态规划.区间DP.石子合并;

import java.util.Scanner;

/**
 * @Description :石子合并
 *
 * 状态表示：  集合：  p[i][j] : 将第i堆石子到第j堆石子 合并成一堆石子的合并方式
 *           属性：  min：代价最小
 * 状态计算： 以最后一次分界线的位置来分类
 *          p[i][j] = min {p[i][k] + p[k+1][j]} + s[j]-s[i] ,k∈（i,i+1...j)
 *
 * @Author : LeafTalk
 * @Data : 2022/2/28
 */
public class Demo01 {
    static int N = 310;
    static int n;
    static int[] s = new int[N]; //前缀和
    static int[][] f = new int[N][N]; //前缀和

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //求前缀和
        for (int i = 1; i <= n; i++) {
            s[i] = s[i-1] + sc.nextInt();
        }

        //len=1，无须合并
        for(int len=2;len<=n;len++){
            for(int i=1;i+len-1<=n;i++){
                int l = i; int r = i+len-1;

                f[l][r] = Integer.MAX_VALUE;
                for(int k=l;k<r;k++){
                   f[l][r] = Math.min(f[l][r] , f[l][k]+ f[k+1][r] + s[r] - s[l-1]) ;
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
