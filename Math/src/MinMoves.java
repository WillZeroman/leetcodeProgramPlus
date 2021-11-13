public class MinMoves {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length<=1){
            return 0;
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += (nums[i]-min);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinMoves().minMoves(new int[]{1,2,3}));
        System.out.println(new MinMoves().minMoves(new int[]{1,2,3,4}));
        System.out.println(new MinMoves().minMoves(new int[]{1,10}));
    }
}
