package ACWing.动态规划.线性DP.最长公共子序列;

import java.util.Scanner;

/**
 * @Description :最长公共子序列
 *
 * 状态表示：  集合：  p[i][j] => a的前i个位置 与 b的前j个位置 构成的公共序列
 *           属性：  max
 * 状态计算： a[i][j]是否包含在子序列当中 为划分依据  (ij相等 , i与j-1相等, j与i-1相等 )
 *              当第i个位置，等于第j个位置时： p[i][j] = p[i-1][j-1]+1
 *              当第i个位置，不等于第j个位置时：去掉a的第i个位置与b比较公共序列，或者去掉b的第j个位置与i比较公共序列
 *              p[i][j] = max ( p[i-1][j], p[i][j-1])
 *
 * 两个序列 s1 abdcbab 和 s2 bdcbabb， 公共子序列 S
 *           1. 如果两个序列最后一个元素相同  (abdcba) b : (bdcbab) b
 *               则 s去掉最后一个元素 还是s1和s2的公共子序列  LCS长度 = LCS(S1[:-1],S2[:-1]) +1
 *           2. 如果最后一个元素不同  (abdcb) a : (bdcba) b
 *              LCS长度 = max( LCS(S1[:-1],S2) ,LCS(s1 , s2[:-1]))   ==>  LCS = MAX( (abdcb)a : (dbcb)a 或者  (abdc)b : (dbcba)b )
 * @Author : LeafTalk
 * @Data : 2022/2/25
 */
public class Demo01 {
    static int N = 1010;
    static int n;
    static int m;
    static int[][] p = new int[N][N];

    //时间复杂度 O(n^2) 空间复杂度 O(n^2)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        char[] s1 = (" " + sc.nextLine()).toCharArray();
        char[] s2 = (" " + sc.nextLine()).toCharArray();

        System.out.println(s1);
        System.out.println(s2);

        for(int i=1; i<= n; i++){
            for(int j=1; j<= m; j++){
                p[i][j] = Math.max(p[i-1][j],p[i][j-1]);
                if(s1[i] == s2[j]){
                    p[i][j] = Math.max(p[i][j], p[i-1][j-1]+1);
                }
            }
        }
        System.out.println(p[n][m]);
    }
}
