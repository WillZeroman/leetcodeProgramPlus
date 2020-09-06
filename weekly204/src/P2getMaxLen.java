import java.util.Arrays;

public class P2getMaxLen {
    public int getMaxLen(int[] nums) {
        int len = nums.length;
        int[] odd = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                odd[i] = 0;
            } else if (nums[i] < 0) {
                if (i > 0) {
                    if (odd[i - 1] < 0) {
                        odd[i] = Math.abs(odd[i - 1]) + 1;
                    } else if (odd[i - 1] == 0) {
                        odd[i] = -1;
                    } else {
                        odd[i] = -(odd[i - 1] + 1);
                    }
                } else {
                    odd[i] = -1;
                }
            } else {
                if (i > 0) {
                    if (odd[i - 1] > 0) {
                        odd[i] = odd[i - 1] + 1;
                    } else if (odd[i - 1] == 0) {
                        odd[i] = 1;
                    } else {
                        odd[i] = odd[i - 1] - 1;
                    }
                } else {
                    odd[i] = 1;
                }
            }
            max = Math.max(max,odd[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {1,-2,-3,4};
        System.out.println(new P2getMaxLen().getMaxLen(nums));
        int[] nums1 = {-1,-2,-3,0,1};
        System.out.println(new P2getMaxLen().getMaxLen(nums1));
        int[] nums2 = {1,2,3,5,-6,4,0,10};
        System.out.println(new P2getMaxLen().getMaxLen(nums2));
    }
}
