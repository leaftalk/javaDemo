package ACWing.数学知识.高斯消元;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :高斯消元解线性方程组
 * @Author : LeafTalk
 * @Data : 2022/1/17
 */
public class Demo01 {
    static int N = 110;
    static int n = 0;
    static double epslon = 1e-6;
    static double[][] arr =new double[N][N];

    //①.找到当前列绝对值最大的行
    //②. 将这一行换到当前最高行上
    //③.将此行的当前列置为1
    //④.将下面所有行的当前列减为0

    //解的情况：1.完美阶梯型，有唯一解； 2.0=0型，无穷多解 3. 0*x=c，无解

    public static int gauss(){
        int c;//col 记录当前列
        int r;//row 记录当前行

        for(c=0,r=0;c<n;c++){
            int t = r;
            for(int i=r;i<n;i++){
                //找到绝对值最大的行数
                if(Math.abs(arr[t][c])< Math.abs(arr[i][c])){
                    t = i;
                }
            }
            //当前行当前最大值为0则continue
            if(Math.abs(arr[t][c])<epslon){
                continue;
            }
            for(int j=c;j<=n;j++){
                //将绝对值最大的行换到最上面
                swap(t,j,r,j);
            }

            for(int k=n;k>=c;k--){
                //将交换后的最上面一行当前列置为1
                arr[r][k] /= arr[r][c];
            }
            //用当前行将下面的行的当前列全部置为0
            for(int x=r+1;x<n;x++){
                if(Math.abs(arr[x][c])> epslon){
                    for(int y=n;y>=c;y--){
                        arr[x][y] -= arr[r][y] * arr[x][c];
                    }
                }
            }
            r++;
        }
        if(r<n){
            for(int i=r;i<n;i++){
                if(Math.abs(arr[i][n]) > epslon){
                    return 2; //无解
                }
            }
            return 1; //无穷多解
        }
        for(int i= n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                arr[i][n] -= arr[i][j] * arr[j][n];
            }
        }
        return 0;
    }

    public static void swap(int r1,int c1,int r2,int c2){
            double mid = arr[r1][c1];
            arr[r1][c1] =arr[r2][c2];
            arr[r2][c2] = mid;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n+1; j++) {
                arr[i][j] = Double.parseDouble(str[j]);
            }
        }
       int res =  gauss();

        if(res==0){
            for (int i = 0; i < n; i++) {
                //去掉输出 -0.00 的情况
                if(Math.abs(arr[i][n])<epslon){
                    arr[i][n] = 0;
                }
                System.out.printf("%.2f\n",arr[i][n]);
            }
        }else if(res ==1){
            System.out.println("Infinite group solutions");
        }else{
            System.out.println("No solution");
        }
    }
}
