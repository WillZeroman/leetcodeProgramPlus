import java.util.Arrays;

public class P3minOperator {
    public int minOperations(int[] nums) {
//        Arrays.sort(nums);
        int count = 0;
        boolean flag = true;
        while (flag) {
            // all is 0 then break;
            flag = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 1) {
                    count++;
                    nums[i] -= 1;
                }
                nums[i] /= 2;
                if (nums[i] != 0) {
                    flag = true;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,4};
        System.out.println(new P3minOperator().minOperations(nums));
    }
}
