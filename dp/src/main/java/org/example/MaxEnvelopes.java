package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int len = envelopes.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (canPut(envelopes[j], envelopes[i])) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private boolean canPut(int[] e1, int[] e2) {
        return e1[0] < e2[0] && e1[1] < e2[1];
    }


    public int maxEnvelopes_best(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            secondDim[i] = envelopes[i][1];
        }
        return lengthOfLIS(secondDim);
    }

    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new MaxEnvelopes().maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2
                , 3}}));
        System.out.println(new MaxEnvelopes().maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}, {1
                , 1}}));
    }
}
