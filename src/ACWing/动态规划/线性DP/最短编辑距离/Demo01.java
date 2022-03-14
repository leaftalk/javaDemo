package ACWing.动态规划.线性DP.最短编辑距离;

import java.util.Scanner;

/**
 * @Description :最短编辑距离
 *
 * 状态表示:  集合 p[i][j] 将a[1~i]变成b[1~j]的操作的集合
 *          属性：min
 * 状态计算： 对a中第i个字母进行不停操作：
 *                          1.删除：a中前i-1个字母跟b中前j个字母匹配，dp[i][j] = dp[i-1][j]+1;
 *                          2.插入: a中前i个字母跟b中前j-1个字母匹配，dp[i][j] = dp[i][j-1]+1;
 *                          3.替换: a中前i-1个字母跟b中前j-1个字母匹配，dp[i][j] = dp[i-1][j-1]+1；
 *                          4.啥也不做：a的第i个字母跟b的第j个字母匹配： dp[i][j] = dp[i-1][j-1];
 *                 dp[i][j] = min { dp[i-1][j]+1,dp[i][j-1]+1 ,dp[i-1][j-1]+1, dp[i-1][j-1] }
 * @Author : LeafTalk
 * @Data : 2022/3/4
 */
public class Demo01 {
    static int N = 1010;
    static char[] a =new char[N];
    static char[] b =new char[N];
    static int[][] dp  =new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        a = (" "+sc.nextLine()).toCharArray(); //数组下标从1开始
        int m = sc.nextInt();
        sc.nextLine();
        b = (" "+sc.nextLine()).toCharArray();


        //初始化操作
        for (int i = 0; i <= m; i++)  dp[0][i] = i; //a长度为0时，执行m次插入操作
        for (int i = 0; i <= n; i++)  dp[i][0] = i;// b长度为0时，执行n次删除操作

        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=m;j++){
                //                     删除           添加
                dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);

                if(a[i] == b[j]){
                    //a[i]等于b[j]，不执行操作
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }else{
                    //a[i]不等于b[j]，执行替换操作
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }

        System.out.println(dp[n][m]);

    }
}
