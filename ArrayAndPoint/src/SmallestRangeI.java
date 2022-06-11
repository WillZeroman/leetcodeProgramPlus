import java.util.Arrays;

public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        if (max - min <= 2 * k) {
            return 0;
        } else {
            return max - min - 2 * k;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SmallestRangeI().smallestRangeI(new int[]{1},0));
        System.out.println(new SmallestRangeI().smallestRangeI(new int[]{0,10},2));
        System.out.println(new SmallestRangeI().smallestRangeI(new int[]{1,3,6},3));
    }
}
