public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max=0;
        for (int num : nums) {
            sum += num;
            max = Math.max(num,max);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        if(max>half){
            return false;
        }
        boolean[][] dp = new boolean[nums.length][half + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= half; j++) {
                if (j<nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length-1][half];
    }
}
