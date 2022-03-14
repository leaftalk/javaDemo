package LeeCode;

/**
 * @Description : 移除元素
 * @Author : LeafTalk
 * @Data : 2021/12/14
 */
public class LC27 {

    //双指针
    public int removeElement(int[] nums, int val) {
            int k =-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[++k] = nums[i];
            }
        }
        return k;
    }

    //双指针优化
    public int removeElement02(int[] nums, int val) {
        int left =0;
        int right = nums.length-1;

        while(left<right){
            if(nums[left] ==val){
                nums[left] = nums[right];
                right--;
            }else{
                left++;
            }
        }
        return left;
    }
}
