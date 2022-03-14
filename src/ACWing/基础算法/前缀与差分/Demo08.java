package ACWing.基础算法.前缀与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :子矩阵的和
 * @Author : LeafTalk
 * @Data : 2021/10/2
 */
public class Demo08 {
    static int X = 1010;
    static int[][] a = new int[X][X];
    //static int[][] b = new int[X][Y];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int q = Integer.parseInt(str[2]);
        for(int i =1;i<=x;i++){
            String[] str02 = bf.readLine().split(" ");
            for(int j=1;j<=y;j++){
                a[i][j] = Integer.parseInt(str02[j-1]);
            }
        }
        for(int i =1;i<=x;i++){
            for(int j=1;j<=y;j++){
                a[i][j] += a[i-1][j] + a[i][j-1] -a[i-1][j-1];
            }
        }
        for(int i=0;i<q;i++){
            String[] str03 = bf.readLine().split(" ");
            int x1 = Integer.parseInt(str03[0]);
            int y1 = Integer.parseInt(str03[1]);
            int x2 = Integer.parseInt(str03[2]);
            int y2 = Integer.parseInt(str03[3]);
            System.out.println(a[x2][y2]-a[x1-1][y2]-a[x2][y1-1]+a[x1-1][y1-1]);

        }
    }

}
