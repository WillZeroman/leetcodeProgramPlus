package longestCommonSubsequence;

/**
 * dp 问题
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        //init
        char text1FirstChar = text1.charAt(0);
        char text2FirstChar = text2.charAt(0);
        for (int i = 0; i < m; i++) {
            char ch = text1.charAt(i);
            if (text2FirstChar == ch) {
                dp[i][0] = 1;
            } else {
                if (i == 0) {
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            char ch = text2.charAt(i);
            if (text1FirstChar == ch) {
                dp[0][i] = 1;
            } else {
                if (i == 0) {
                    dp[0][i] = 0;
                } else {
                    dp[0][i] = dp[0][i - 1];
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char firstChar = text1.charAt(i);
                char secondChar = text2.charAt(j);
                if(firstChar != secondChar){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        //System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
        //System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "abc"));
        //System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "def"));
        //System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "abbbcccc"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("bl", "yby"));
        //"bsbininm"
        //"jmjkbkjkv"
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }
}
