import java.util.Arrays;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 || len2 == 0) {
            return Math.max(len1, len2);
        }
        //dp[i][j] 表示 word1[0..i] word2[0..j] 中最长公共子序列
        int[][] dp = new int[len1][len2];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 1 : 0;
        for (int i = 1; i < len1; i++) {
            dp[i][0] = Math.min(1, dp[i - 1][0] + (word1.charAt(i) == word2.charAt(0) ? 1 : 0));
        }
        for (int i = 1; i < len2; i++) {
            dp[0][i] = Math.min(1, dp[0][i - 1] + (word2.charAt(i) == word1.charAt(0) ? 1 : 0));
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return (len1 - dp[len1 - 1][len2 - 1]) + (len2 - dp[len1 - 1][len2 - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("sea", "eat"));
        System.out.println(new MinDistance().minDistance("leetcodo", "etco"));
    }
}
