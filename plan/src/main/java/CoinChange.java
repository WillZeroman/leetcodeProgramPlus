public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //dp[i] = 1+Min(dp[i-coins[j]])
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    min = Math.min(min, dp[i - coin]);
                }
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = Integer.MAX_VALUE;
            } else {
                dp[i] = 1 + min;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5},11));
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5},4));
        System.out.println(new CoinChange().coinChange(new int[]{2,3,5},11));
        System.out.println(new CoinChange().coinChange(new int[]{2},3));
        System.out.println(new CoinChange().coinChange(new int[]{2},0));
        System.out.println(new CoinChange().coinChange(new int[]{1},1));
    }
}
