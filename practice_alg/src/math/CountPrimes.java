package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] nums = new boolean[n];
        Arrays.fill(nums, true);
        nums[0] = false;
        nums[1] = false;
        List<Integer> ans = new ArrayList<>();
        ans.add(2);
        for (int i = 3; i < n; i += 2) {
            if (nums[i]) {
                ans.add(i);
                for (int j = i * 2; j < n; j += i) {
                    nums[j] = false;
                }
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10));
        System.out.println(new CountPrimes().countPrimes(0));
        System.out.println(new CountPrimes().countPrimes(1));
        System.out.println(new CountPrimes().countPrimes(2));
        System.out.println(new CountPrimes().countPrimes(3));
    }
}
