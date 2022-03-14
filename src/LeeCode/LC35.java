package LeeCode;

/**
 * @Description :搜索插入的位置（二分）
 * @Author : LeafTalk
 * @Data : 2021/12/17
 */
public class LC35 {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(target < nums[0]){
            return 0;
        }
        if(target > nums[n - 1]){
            return n;
        }
        int high = n-1;
        int low = 0;
        while(low <= high){
            int mid = (low + high ) >> 1;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
