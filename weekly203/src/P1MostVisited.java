import java.util.ArrayList;
import java.util.List;

public class P1MostVisited {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] nums = new int[n + 1];
        nums[rounds[0]] = 1;
        for (int i = 1; i < rounds.length; i++) {
            int start = rounds[i - 1];
            int end = rounds[i];
            if (start < end) {
                for (int k = start + 1; k <= end; k++) {
                    nums[k] += 1;
                }
            } else {
                end += n;
                for (int k = start + 1; k <= end; k++) {
                    if (k > n) {
                        nums[k % n] += 1;
                    } else {
                        nums[k] += 1;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int max = nums[0];
        for (int i = 1; i < n + 1; i++) {
            if (max == nums[i]) {
                res.add(i);
            } else {
                if (max < nums[i]) {
                    res.clear();
                    max = nums[i];
                    res.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] rounds = {3, 2, 1, 2, 1, 3, 2, 1, 2, 1, 3, 2, 3, 1};
        System.out.println(new P1MostVisited().mostVisited(3, rounds));
    }
}
