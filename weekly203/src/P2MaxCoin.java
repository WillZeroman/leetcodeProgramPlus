import java.util.Arrays;

public class P2MaxCoin {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = 0;
        int j = piles.length - 1;
        int sum = 0;
        while (i < j) {
            sum += piles[j - 1];
            i++;
            j -= 2;
        }
        return sum;
    }
}
