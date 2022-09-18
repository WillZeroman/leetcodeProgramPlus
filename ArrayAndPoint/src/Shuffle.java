import java.util.Arrays;

public class Shuffle {
    public int[] shuffle(int[] nums, int n) {
        int half = n;
        int[] ans = new int[nums.length];
        int left = 0;
        int index = 0;
        while (index < nums.length) {
            ans[index] = nums[left];
            index++;
            left++;
            ans[index] = nums[half];
            index++;
            half++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Shuffle().shuffle(new int[]{2,5,1,3,4,7},3)));
        System.out.println(Arrays.toString(new Shuffle().shuffle(new int[]{1,1,2,2},2)));
    }
}
