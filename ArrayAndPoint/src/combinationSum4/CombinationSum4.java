package combinationSum4;

import java.util.Arrays;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ans = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] > 0) {
                    sum += ans[i - nums[j]];
                }
                if (nums[j] == i) {
                    sum += 1;
                }
            }
            ans[i] += sum;
        }
        System.out.println(Arrays.toString(ans));
        return ans[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum4().combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(new CombinationSum4().combinationSum4(new int[]{1, 2, 3}, 5));
        System.out.println(new CombinationSum4().combinationSum4(new int[]{9}, 3));
    }
}
