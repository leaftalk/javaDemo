package ACWing.动态规划.线性DP.最长上升子序列;

import java.util.Scanner;

/**
 * @Description :最长上升子序列II
 * 数据范围: 0~100000
 * @Author : LeafTalk
 * @Data : 2022/3/1
 */
public class Demo02 {
    static int N =100010;
    static int n;
    static int[] arr = new int[N];
    static int[] dp = new int[N];

    //时间复杂度 O(nlogn)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            System.out.println(arr[i]);
        }

        dp[1] = arr[1];
        int len=1;
        for (int i = 2; i <= n; i++) {
            //如果arr[i]大于子序列最后一个数，直接加入到子序列中
            if(arr[i]> dp[len]){
                dp[++len] = arr[i];
            }else{
            //如果arr[i]小于子序列最后一个数，则找到子序列中第一个大于等于arr[i]的数进行替换
            //如替换后的序列，并不是原序列的上升子序列，也没有关系，因为len值一直保存的最后一次合法的上升子序列的长度
            //例：4，8，9，5，6，7，2，7
            //dp[1] =4 => dp[2] =8 => dp[3] =9
            //到5时，此时 dp={4,8,9} ==> {4,5,9}    此时4,5,9并不是序列的上升子序列，但是长度仍为 {4，8，9}时的3
            //到6时， dp= {4,5,9} ==>{4,5,6}
            //dp[4] = 7                            当且仅当子序列末尾添加时，len才会增加
            //到2时，dp={4,5,6,7} ===> {2,5,6,7}
            //到7时 dp={2，5，6，7}
            //最终长度为4
                int l = 1;int r = len;
                while(l<r){
                    int mid = (l+r) >> 1;
                    if(dp[mid]<arr[i]) l=mid+1;
                    else r = mid;
                }
                dp[r] = arr[i];
            }
        }
        System.out.println(len);
    }
}
