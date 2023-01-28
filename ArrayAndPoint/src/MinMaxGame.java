public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        int n = nums.length/2;
        while (n > 0) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            n /=2;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new MinMaxGame().minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
        System.out.println(new MinMaxGame().minMaxGame(new int[]{3}));
        System.out.println(new MinMaxGame().minMaxGame(new int[]{5, 4}));
    }
}
