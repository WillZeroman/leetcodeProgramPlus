import java.util.Arrays;

public class FindPairs {
    public int findPairs(int[] nums, int k) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        int left = 0;
        int right = 1;
        while (right < nums.length && left <= right) {
            int diff = nums[right] - nums[left];
            if (diff < k || left == right) {
                right++;
            } else if (diff == k) {
                if (left == 0 || nums[left] != nums[left - 1]) {
                    ans++;
                }
                left++;
                right++;
            } else {
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindPairs().findPairs(new int[]{1, 1, 3, 4, 5}, 2));
        System.out.println(new FindPairs().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(new FindPairs().findPairs(new int[]{1, 3, 1, 4, 5}, 0));
    }
}
