import java.util.Arrays;

public class MinMoves2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int diff = nums[right] - nums[left];
            ans += diff;
            left++;
            right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinMoves2().minMoves2(new int[]{1,2,3}));
        System.out.println(new MinMoves2().minMoves2(new int[]{1,10,2,9}));
        System.out.println(new MinMoves2().minMoves2(new int[]{1,3,4,5}));
    }
}
