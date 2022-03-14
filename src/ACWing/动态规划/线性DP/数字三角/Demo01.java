package ACWing.动态规划.线性DP.数字三角;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Description :数字三角形
 * 行           (1
 * 1          7   2
 * 2        3   8   3
 * 3      8   1   0   4
 * 4    2   7   4   4   5)列
 * 5  4   5   2   6   5
 *
 * 状态表示：  集合：  p[i][j] => 从起点走到第i行第j列的路径
 *           属性：  max
 * 状态计算： 从上往下走 p[i][j] = max( p[i-1][j-1], p[i-1][j]) +a[i][j]从左上方走到[i][j],或者从右上方走到[i][j]这个点
 *          从下往上走 p[i][j] = max( p[i][j+1], p[i+1][j+1]) + arr[i][j]; 从左上方走到[i][j],或者从右上方走到[i][j]这个点
 * @Author : LeafTalk
 * @Data : 2022/2/22
 */
public class Demo01 {
    static int N = 510;
    static int n;
    static int inf = Integer.MIN_VALUE;
    static int[][] arr = new int[N][N];
    static int[][] p = new int[N][N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n  = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int i1 = 1; i1 <= i; i1++) {
                arr[i][i1] = in.nextInt();
            }
        }

    }

    //从上往下走 , 时间复杂度 o(n^2)
    //为什么从上往下走需要初始化设置 p[i][j] = Integer.MIN_VALUE
    //因为当计算 p[x][x]对角线上的位置时，只有左上的父母，右上的父母没有值，默认为0，如果左上父母为复数，则回取右上的父母0，
    public static void triangle01(){
        //i，j从0开始初始化，因为第1行第1列在计算时，f[1][1] = max( f[0][0]+a[1][1] , f[0][1]+a[1][1] )
        //同时 j初始化时，要比i多1，因为 例如 f[2][2]，f[3][3]../在计算右上方的路径时为 f[1][2],所以要多初始化一个
        for(int i=0;i<=n;i++){
            for(int j=0;j<=i+1;j++){
                p[i][j] = inf;
            }
        }


        p[1][1] = arr[1][1];
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                //如果f[i][j]= Math.max(f[i - 1][j - 1] + a[i][j], f[i - 1][j] + a[i][j])
                // 其中的f[i - 1][j - 1]如果为Integer.MIN_VALUE,并且a[i][j] = 负数时候，会溢出！！！
                // 需要写成 Math.max(f[i - 1][j - 1] + f[i - 1][j]);
                p[i][j] = Math.max(p[i-1][j-1],p[i-1][j])+arr[i][j];
            }
        }

        int a=inf;
        for(int i=1;i<=n;i++){
            a=Math.max(a,p[n][i]);
        }
        System.out.println(a);
    }

    //从下往上走 (不需要考虑初始化的边界问题)
    public static void triangle02(){
            for(int i=n;i>=1;i--){
                for(int j=1;j<=n;j++){
                    p[i][j] = Math.max( p[i][j+1], p[i+1][j+1]) + arr[i][j];
                }
            }
        System.out.println(arr[1][1]);
    }
}
