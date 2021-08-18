public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int dif = nums[right] - nums[left];
        int ans = 0;
        for (; right < nums.length; right++) {
            if (nums[right] - nums[right - 1] != dif) {
                ans += compute(left, right);
                left = right - 1;
                dif = nums[right] - nums[left];
            }
        }
        if (right - left >= 3) {
            ans += compute(left, right);
        }

        return ans;
    }

    private int compute(int left, int right) {
        int count = 0;
        int num = right - left;
        for (int i = 3; i <= num; i++) {
            int tmpCnt = num - i + 1;
            count += tmpCnt;
        }
        return count;
    }
}
