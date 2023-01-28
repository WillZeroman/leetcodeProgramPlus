public class MaxAscendingSum {
    public int maxAscendingSum(int[] nums) {
        int ans = nums[0];
        int tempSum = ans;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                tempSum += nums[i];
            } else {
                ans = Math.max(ans,tempSum);
                ans = Math.max(ans,nums[i]);
                tempSum = nums[i];
            }
        }
        ans = Math.max(ans,tempSum);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxAscendingSum().maxAscendingSum(new int[]{10,20,30,5,10,50}));
        System.out.println(new MaxAscendingSum().maxAscendingSum(new int[]{10,20,30}));
        System.out.println(new MaxAscendingSum().maxAscendingSum(new int[]{100,10,1}));
        System.out.println(new MaxAscendingSum().maxAscendingSum(new int[]{1,2,3,4}));
    }
}
