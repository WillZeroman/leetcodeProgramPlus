import java.util.Arrays;

public class FinalPrices {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int oldPrice = prices[i];
            ans[i] = oldPrice;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= oldPrice) {
                    ans[i] = oldPrice - prices[j];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FinalPrices().finalPrices(new int[]{8,4,6,2,3})));
        System.out.println(Arrays.toString(new FinalPrices().finalPrices(new int[]{1,2,3,4,5})));
    }
}
