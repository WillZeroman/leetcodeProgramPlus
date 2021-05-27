import java.util.Arrays;

public class PurchasePlans {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        long count = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] <= target) {
                count += (end - start);
                start++;
            } else {
                end--;
            }
        }
        return (int) (count % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new PurchasePlans().purchasePlans(new int[]{2, 5, 3, 5}, 6));
        System.out.println(new PurchasePlans().purchasePlans(new int[]{2, 2, 1, 9}, 10));
    }
}
