import java.util.Arrays;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int[] cnt = new int[nums.length];
        cnt[0] = 1;
        int ans=0;
        int maxLen =0;
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < currentNum) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                ans = cnt[i];
            } else if(dp[i] == maxLen){
                ans += cnt[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(cnt));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(new int[]{1,1,1,2,2,2,3,3,3}));
    }
}
