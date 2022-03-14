package ACWing;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 * @Description :
 * @Author : LeafTalk
 * @Data : 2021/10/25
 */
public class Test {
    static int N=110;

    static double eps=1e-6;
    static double[][] a=new double[N][N];
    static int n;

    static void swap(int x1, int y1, int x2, int y2){
        double tmp = a[x1][y1];
        a[x1][y1] = a[x2][y2];
        a[x2][y2] = tmp;
    }

    static int gauss(){
        int r,c; //r表示行，c表示列
        //枚举所有的列
        for(r=0, c=0; c<n; c++){

            //找到当前这一列中绝对值最大的那一行
            int t = r;
            for(int i=r; i<n; i++){
                if(Math.abs(a[i][c])>Math.abs(a[t][c])){
                    t = i;
                }
            }
            //如果当前最大的值为0，就continue
            if(Math.abs(a[t][c]) < eps) continue;
            //将这一行放到当前所有行的上面
            for(int i=c; i<=n; i++) swap(t, i, r, i);
            //将第一行的第一个数字变为1
            for(int i=n; i>=c; i--) a[r][i] /= a[r][c];

            //将剩下所有行的第一个数字变为0
            for(int i=r+1; i<n; i++){
                if(Math.abs(a[i][c]) < eps) continue;
                for(int j=n; j>=c; j--){
                    a[i][j] -= a[r][j]*a[i][c];
                }
            }

            r++;
        }

        if(r<n){
            for(int i=r; i<n; i++){
                if(Math.abs(a[i][n]) > eps) return 2;
            }
            return 1;
        }

        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                a[i][n] -= a[i][j]*a[j][n];
            }
        }
        return 0;
    }

    public static void main(String[]args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(in.readLine());

        for(int i=0;i<n;i++){
            String[]arr=in.readLine().split(" ");
            for(int j=0;j<n+1;j++){
                a[i][j]=Double.parseDouble(arr[j]);
            }
        }

        int t=gauss();

        if(t==0){
            for(int i=0;i<n;i++) {
                if(Math.abs(a[i][n])<eps){
                    a[i][n] = 0;
                }
                System.out.printf("%.2f\n",a[i][n]);
            }

        }
        else if(t==1) System.out.println("Infinite group solutions");
        else System.out.println("No solution");
    }
}


