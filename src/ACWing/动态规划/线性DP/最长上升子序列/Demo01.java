package ACWing.动态规划.线性DP.最长上升子序列;

import java.util.Scanner;

/**
 * @Description :最长上升子序列
 *
 *
 * * 状态表示：  集合：  p[i] => 表示第i个位置结尾的递增子序列
 *  *           属性：  max
 *  * 状态计算：  p[i] = max(p[i],p[i-1]+1)
 *              第i个位置的子序列的倒数第二个位是第几个数（0，1，2...i-1）如果存在的话(a[k]< a[i])
 * @Author : LeafTalk
 * @Data : 2022/2/22
 */
public class Demo01 {
    static int N = 1010;
    static int[] arr = new int[N];
    static int[] p = new int[N];

    //时间复杂度 o(n^2)=状态数量*每个状态的计算量
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
             arr[i] = sc.nextInt();
        }

        for(int i=1;i<=n;i++){
            p[i] = 1; //只有arr[i]一个数
            for(int j=1;j<=i-1;j++){
                if(arr[j]<arr[i]){
                    p[i] = Math.max(p[i],p[j]+1);
                }
            }
        }

        int res=0;
        for (int i = 1; i <= n; i++) {
            res= Math.max(res,p[i]);
        }

        System.out.println(res);
    }
}
