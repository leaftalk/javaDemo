package ACWing.动态规划.线性DP.编辑距离;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description :编辑距离
 *
 * @Author : LeafTalk
 * @Data : 2022/3/7
 */
public class Demo01 {
    static int N = 1010;
    static List<String> list = new ArrayList<>();
    static char[][] b = new char[N][15]; // 询问字符串
    static int[] c = new int[N]; //操作上限
    static int[][] dp=new int[N][N];

    //100,000,000
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n个字符串
        int m = sc.nextInt(); //m次询问
        while(n-->0){
            list.add(sc.next());
        }
        while(m-->0) {
            String b =sc.next();
            int limit = sc.nextInt();
            int res=0;
            for(String s:list){
                int ret = editDistance(s,b);
                if(ret<=limit){
                    ++res;
                }
            }
            System.out.println(res);
        }



    }

    public static int editDistance(String a,String b){
            int n =a.length();
            int m = b.length();
            a = " "+a;
            b = " "+b;
            //初始化
            for(int x=0;x<=n;x++) dp[x][0] =x;
            for(int y=0;y<=m;y++) dp[0][y] = y;

            for(int x=1;x<=n;x++){
                for(int y=1;y<=m;y++){
                    dp[x][y] = Math.min(dp[x-1][y]+1,dp[x][y-1]+1);
                    if(a.charAt(x) == b.charAt(y)){
                        dp[x][y] = Math.min(dp[x][y],dp[x-1][y-1]);
                    }else{
                        dp[x][y] = Math.min(dp[x][y],dp[x-1][y-1]+1);
                    }
                }
            }
            return dp[n][m];
    }

}
