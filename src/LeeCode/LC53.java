package LeeCode;

/**
 * @Description :
 * @Author : LeafTalk
 * @Data : 2021/12/17
 */
public class LC53 {
    public static void main(String[] args) {
        int[] a ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }

    //动态规划
    public static int maxSubArray(int[] nums) {
        int pre = 0; int max = nums[0];
        for (int x:nums) {
            pre = Math.max(pre+x,x);
            max = Math.max(pre,max);
        }
        return max;
    }

    //分治
    public static int maxSubArray02(int[] nums) {
        return getInfo(nums,0,nums.length-1).mSum;
    }

    public static Status getInfo(int[] a,int l,int r){
        if(l == r){
            return new Status(a[0],a[0],a[0],a[0]);
        }
        int mid = (l + r) >> 1;
        Status left = getInfo(a,l,mid);
        Status right = getInfo(a,mid+1,r);
        return pushUp(left,right);
    }

    public static  Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum,l.iSum + r.lSum);
        int rSum = Math.max(r.rSum,r.iSum + l.rSum);
        int mSum = Math.max(Math.max(r.mSum,l.mSum),r.mSum + l.mSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

}
class Status{
    public int lSum, rSum, mSum, iSum;

    public Status(int lSum, int rSum, int mSum, int iSum) {
        this.lSum = lSum;
        this.rSum = rSum;
        this.mSum = mSum;
        this.iSum = iSum;
    }

}
