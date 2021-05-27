package range;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                int end = i - 1;
                if (start == end) {
                    result.add(nums[start] + "");
                } else {
                    result.add(nums[start] + "->" + nums[end]);
                }
                start = i;
            }
        }
        if (start == nums.length-1) {
            result.add(nums[start] + "");
        } else {
            result.add(nums[start] + "->" + nums[nums.length-1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(new SummaryRanges().summaryRanges(nums));

        int[] nums1 = {0,2,3,4,6,8,9};
        System.out.println(new SummaryRanges().summaryRanges(nums1));
        System.out.println(new SummaryRanges().summaryRanges(new int[0]));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{-1}));

    }
}
