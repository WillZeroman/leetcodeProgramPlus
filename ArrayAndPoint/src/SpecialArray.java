import java.util.Arrays;

public class SpecialArray {
    public int specialArray(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i <= size && index < size; i++) {
            while (index < size && i > nums[index]) {
                index++;
            }
            if (index < size && i <= nums[index]) {
                // check
                if (size - index == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SpecialArray().specialArray(new int[]{0,0}));
        System.out.println(new SpecialArray().specialArray(new int[]{3,5}));
    }
}
