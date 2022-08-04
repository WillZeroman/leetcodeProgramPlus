import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int maxNumSum = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            maxNumSum += nums[i];
            ans.add(nums[i]);
            if (maxNumSum > (sum - maxNumSum)) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubsequence().minSubsequence(new int[]{4,3,10,9,8}));
        System.out.println(new MinSubsequence().minSubsequence(new int[]{4,4,7,6,7}));
        System.out.println(new MinSubsequence().minSubsequence(new int[]{4}));
        System.out.println(new MinSubsequence().minSubsequence(new int[]{1,1}));
    }
}
