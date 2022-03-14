package ACWing.基础算法.二分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个按照升序排列的长度为 n 的整数数组，以及 q 个查询。
 * 对于每个查询，返回一个元素 k 的起始位置和终止位置（位置从 0 开始计数）。
 * 如果数组中不存在该元素，则返回 -1 -1。
 *
 *
 * 二分查找
 * @Author : LeafTalk
 * @Data : 2021/9/25
 */
public class Demo02 {
    static final int N = 100010;
    static int[] arr = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] a = in.readLine().split(" ");
       int n = Integer.parseInt(a[0]);
       int q = Integer.parseInt(a[1]);
       String[] str = in.readLine().split(" ");
       for(int i=0;i<n;i++) arr[i] = Integer.parseInt(str[i]);

       while(q-->0){
           int k = Integer.parseInt(in.readLine());
            int l=0,r = n-1;
            while(l<r){
                int mid = l +r >> 1;
                if(arr[mid]>= k) r=mid;
                else l=mid+1;
            }
            int left = r;
            if(arr[l] !=k){
                System.out.println("-1 -1");
            }else{
                l = 0;r = n-1;
                while(l<r){
                    int mid =l+r +1 >>1;
                    if(arr[mid]<= k) l=mid;
                    else r = mid-1;
                }
                System.out.println(left + " " + l);
            }

       }
    }
}
