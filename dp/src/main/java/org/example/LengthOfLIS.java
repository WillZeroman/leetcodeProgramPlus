package org.example;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{7,7,7,7}));
    }
}
