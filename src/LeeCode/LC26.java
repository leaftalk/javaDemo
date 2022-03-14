package LeeCode;

/**
 * @Description :删除有序数组中的重复项
 * @Author : LeafTalk
 * @Data : 2021/12/13
 */
public class LC26 {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int k=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[++k] = nums[i];
            }
        }
        return k;
    }
}
