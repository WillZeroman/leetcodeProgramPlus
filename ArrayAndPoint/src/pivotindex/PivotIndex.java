package pivotindex;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int index = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int left = 0;
        int right = sum;
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (i > 0) {
                left += nums[i - 1];
            }
            if (left == right) {
                index = i;
                break;
            }
        }

        return index;
    }
}
