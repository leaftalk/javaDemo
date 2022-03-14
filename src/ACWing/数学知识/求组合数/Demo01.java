package ACWing.数学知识.求组合数;

import java.io.*;

/**
 * @Description :求组合数I
 * @Author : LeafTalk
 * @Data : 2022/1/26
 */
public class Demo01 {
    static int N = 2010;
    static int mod = 1000000007;
    static int[][] c = new int[N][N];

    public static void init(){
        for(int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    c[i][j] =  1;
                }else{
                    c[i][j] = (c[i-1][j-1] + c[i-1][j]) % mod;
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            System.out.println(c[a][b]);
        }

    }
}
