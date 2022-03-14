package ACWing.基础算法.前缀与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description :差分矩阵
 * @Author : LeafTalk
 * @Data : 2021/10/2
 */
public class Demo10 {
    static int N = 1010;
    static int[][] a = new int[N][N];
    static int[][] b = new int[N][N];

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
               add(i,j,i,j,a[i][j]);
            }
        }

        for(int i=0;i<q;i++){
            String[] str03 = bf.readLine().split(" ");
            int x1 = Integer.parseInt(str03[0]);
            int y1 = Integer.parseInt(str03[1]);
            int x2 = Integer.parseInt(str03[2]);
            int y2 = Integer.parseInt(str03[3]);
            int c = Integer.parseInt(str03[4]);
            add(x1,y1,x2,y2,c);
        }

        //做前缀和
        for(int i =1;i<=x;i++){
            for(int j=1;j<=y;j++){
               b[i][j] += b[i][j-1] + b[i-1][j] - b[i-1][j-1];
            }
        }
        for(int i =1;i<=x;i++){
            for(int j=1;j<=y;j++){
                System.out.println(b[i][j]+ " ");
            }
        }

    }

    public static void add(int x1,int y1,int x2,int y2,int c){
        b[x1][y1] += c;
        b[x2+1][y1] -= c;
        b[x1][y2+1] -= c;
        b[x2+1][y2+1] += c;
    }
}
