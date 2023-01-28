package org.example;

import java.util.Arrays;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int ans = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                ans = count[i];
            } else if(maxLen == dp[i]){
                ans += count[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }
}
