package randompick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Solution {

    private Random random;

    private Map<Integer, Integer> blackToWhite = new HashMap<>();

    private int bound;

    public Solution(int n, int[] blacklist) {
        bound = n - blacklist.length;
        Set<Integer> blackSet = new HashSet<>();
        Arrays.stream(blacklist).filter(i -> i >= bound).forEach(i -> blackSet.add(i));
        int j = bound;
        for (int black : blacklist) {
            if (black < bound) {
                while (blackSet.contains(j)) {
                    j++;
                }
                blackToWhite.put(black, j);
                j++;
            }
        }
        random = new Random();
    }

    public int pick() {
        int r = random.nextInt(bound);
        return blackToWhite.getOrDefault(r, r);
    }

    public static void main(String[] args) {
        Solution solution = new Solution(7, new int[]{2, 3, 5});
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.pick());
        }
    }
}
