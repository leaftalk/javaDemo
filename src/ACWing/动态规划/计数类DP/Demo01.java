package ACWing.动态规划.计数类DP;

import java.util.Scanner;

/**
 * @Description :整数划分
 *一个正整数 n 可以表示成若干个正整数之和，形如：n=n1+n2+…+nk， 请你求出n共有多少种划分方式
 *
 * 类比背包问题： 背包容量为N,物品提交为1,2,3...n;每个物品可以取无穷多种
 *
 * 方案一：
 * 状态表示：  集合：p[i][j]   从1~i个物品中选任意个体积加起来等于j的物品个数
 *           属性：数量
 * 状态计算： 根据第i个物品选择多少个来划分
 *             f[i,j] = {选0个i,选1个i,选2个i.....选s个i} => {f[i-1,j],f[i-1,j-i],f[i-1,j-2i].....f[i-1,j-si]}
 *             f[i,j] = f[i-1,j] + f[i-1,j-i] + f[i-1,j-2i]..... + f[i-1,j-si];所有选法的和
 *          又 f[i,j-i] =          f[i-1,j-i] + f[i-1,j-2i]......+ f[i-1,j-si];
 *           ==>f[i,j] =  f[i-1,j] + f[i,j-i] 状态转移方程（从前i-1个物品中选体积为j的方案书数+从前i个物品中选体积为j-i的方案数）
 *
 * 方案二：
 * 状态表示：  集合：p[i][j]  和为i，恰好由j个数的方案数
 *           属性：数量
 * 状态计算： 根据所选数中最小值是否为1来进行划分： {最小值为1| 最小值不为1} => {dp[i-1][j-1](去掉1的状态方程) | dp[i-j][j] (每个数都去掉1的状态方程) }
 *                                          dp[i,j] = dp[i-1,j-1] + dp[i-j,j]
 * @Author : LeafTalk
 * @Data : 2022/3/7
 */
public class Demo01 {
    static int N=1010;
    static int mod =1000000007;
    static int m;
    static int[][] dp = new int[N][N];
    static int[] dp02 = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m =sc.nextInt();

        counter();

    }

    // f[i,j] = f[i-1,j] + f[i-1,j-i] + f[i-1,j-2i]..... + f[i-1,j-si];
    public static void counter(){
        dp[0][0] = 1;
        //前i个数
        for(int i=1;i<=m;i++){
            //体积为j
            for(int j=0;j<=m;j++){
                //第i个数的个数
                for(int k=0;k*i<=j;k++){
                    dp[i][j] += dp[i-1][j-k*i];
                    dp[i][j] %= mod;
                }
            }
        }
        System.out.println(dp[m][m]);
    }

    // f[i,j] = f[i-1,j] + f[i,j-i];
    //f[j] = f[j] + f[j-i]
    public static void counter02(){
        dp02[0] = 1;
        for(int i=1;i<=m;i++){
            for(int j=i;j<=m;j++){
                dp02[j] = (dp02[j]+dp02[j-i])%mod;
            }
        }
        System.out.println(dp02[m]);
    }

    public static void counter03(){
        dp[0][0] = 1;
        //i是和
        for(int i=1;i<=m;i++){
            //j表示划分的个数
            for(int j=1;j<=i;j++){
                dp[i][j] = (dp[i-1][j-1]+dp[i-j][j] ) % mod;
            }
        }
        int res =0;
        for(int i=1;i<=m;i++){
            res = (res + dp[m][i]) %mod;
        }
        System.out.println(res);
    }
}
