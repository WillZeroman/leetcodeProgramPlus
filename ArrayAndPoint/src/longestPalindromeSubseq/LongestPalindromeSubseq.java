package longestPalindromeSubseq;

public class LongestPalindromeSubseq {
    /**
     * dp
     *
     * 两个字符串最长子序列
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int len =s.length();
        int[][] dp = new int[len][len];
        for (int i = len-1; i >=0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for(int j=i+1;j<len;j++){
                char c2 = s.charAt(j);
                if(c1 == c2){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
