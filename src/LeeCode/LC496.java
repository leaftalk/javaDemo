package LeeCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :下一个更大元素 （单调栈）
 * @Author : LeafTalk
 * @Data : 2022/1/6
 */
public class LC496 {
    public static void main(String[] args) throws IOException {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = nextGreaterElement03(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    static public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] stack = new int[len2];

        int[] res = new int[len1];

        for(int i=0;i<len1;i++){
            int top =-1;
            int j = len2-1;
            int a = nums1[i];
           b: while(j>=0){
                if(nums2[j] == a){
                    while(top>=0 && stack[top] <nums2[j]){
                        top--;
                    }
                    if(top<0){
                        res[i] = -1;
                        stack[++top] = nums2[j];
                        break b;
                    }else{
                        res[i] = stack[top];
                    }
                }
                stack[++top] = nums2[j];
                j--;
            }
        }
        return res;

    }
    //预先处理nums2
    public static int[] nextGreaterElement02(int[] nums1, int[] nums2) {
        int len2 = nums2.length;
        int[] stack = new int[len2];
        int top = -1;

        int[] res = new int[nums1.length];
        int i =0;
        for(int j =len2-1;j>=0;j--){
               while(top>=0 && stack[top]<nums2[j]){
                   top--;
               }

            for(int k=0;k<nums1.length;k++){
                    if(nums1[k] == nums2[j]){
                        if(top<0){
                            res[k] = -1;
                        }else{
                            res[k] = stack[top];
                        }
                    }
            }

            stack[++top] = nums2[j];
        }

        return res;

    }

    //map优化  O(n+m)
    public static int[] nextGreaterElement03(int[] nums1, int[] nums2) {
        int len2 = nums2.length;
        int[] stack = new int[len2];
        int top = -1;

        Map<Integer,Integer> map = new HashMap<>();
        for(int j =len2-1;j>=0;j--){
            while(top>=0 && stack[top]<nums2[j]){
                top--;
            }
                    if(top<0){
                       map.put(nums2[j],-1);
                    }else{
                       map.put(nums2[j],stack[top]);
                    }
            stack[++top] = nums2[j];
        }

        int[] res = new int[nums1.length];
        for (int i1 = 0; i1 < nums1.length; i1++) {
            int a = map.get(nums1[i1]);
            res[i1] = a;
        }

        return res;

    }
}
