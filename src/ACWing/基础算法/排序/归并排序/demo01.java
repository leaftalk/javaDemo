package ACWing.基础算法.排序.归并排序;

import java.util.Scanner;

/**
 * 归并排序
 * @Author : LeafTalk
 * @Data : 2021/9/23
 */
public class demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] arr02 = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            arr02[i] = sc.nextInt();
        }
        quickSort(arr02,0,n-1);

//        for(int i = 0; i < n; i++){
//            System.out.print(arr[i] + " ");
//        }
    }
    public static void quickSort(int[] nums,int low,int high) {
        if(low<high){
           int mid =  (low+high)/2;
            quickSort(nums,low,mid);
            quickSort(nums,mid+1,high);
            sort(nums,low,mid,high);
        }
    }

    public static void sort(int[] nums,int low,int mid,int high){
        int[] nums02 =new int[nums.length];
        for (int i=low;i<=high;i++) {
            nums02[i] = nums[i];
        }
        int a =low;
        int b = mid+1;
        int k = low;
        for(;a<=mid && b<=high;k++){
            if(nums02[a]<=nums02[b]){
                nums[k] = nums02[a++];
            }else{
                nums[k] = nums02[b++];
            }
        }
        while(a <=mid) nums[k++] = nums02[a++];
        while(b <= high) nums[k++] = nums02[b++];
    }
}
