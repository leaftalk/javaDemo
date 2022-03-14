package ACWing.排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description : 快速排序
 * @Author : LeafTalk
 * @Data : 2021/12/28
 */
public class Demo01 {
    static int N = 100010;
    static int[] arr = new int[N];

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           int n = Integer.parseInt(br.readLine());
           String[] m = br.readLine().split(" ");
           for(int i=0;i<n;i++){
               arr[i] = Integer.parseInt(m[i]);
           }
        sort(arr,0,n-1);

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }

    }
    public static void sort(int[] nums,int low,int high){
        if(low<high){
            int a = quickSort(nums,low,high);
            sort(nums,low,a-1);
            sort(nums,a+1,high);
        }
    }

    public static int quickSort(int[] nums,int left,int right){
            int mid = nums[left]; int i = left; int j = right;
            while(i<j){
                while(nums[j] >= mid){
                    j--;
                }
                nums[i] = nums[j];
                while(nums[i]<= mid){
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = mid;
            return i;
    }

    public static void quickSort02(int[] nums,int left,int right){
        if(left>= right){
            return;
        }
        int mid = left;int l =left-1; int r = right+1;
        while(l<r){
            do{
                l++;
            }while(nums[l]<nums[mid]);

            do{
                r--;
            }while(nums[r]>nums[mid]);

            if(l<r){
                int a = nums[l];
                nums[l] = nums[r];
                nums[r] = a;
            }
        }
        quickSort02(nums,left,r);
        quickSort02(nums,r+1,right);
    }
}
