public class NaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int ans=nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new NaxSubArray().maxSubArray(new int[]{1,-1}));
        System.out.println(new NaxSubArray().maxSubArray(new int[]{-1}));
    }
}
