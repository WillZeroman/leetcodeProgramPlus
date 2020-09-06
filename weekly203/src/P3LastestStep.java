import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P3LastestStep {

    private Set<Integer> set = new HashSet<>();

    public int findLatestStep(int[] arr, int m) {
        int[] nums = new int[arr.length + 1];
        Arrays.fill(nums, 1);
        nums[0] = 0;
        if (arr.length == m) {
            return arr.length;
        }
        set.add(arr.length);
        int latestStep = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int v = arr[i];
            nums[v] = 0;
            // check
            if (check(nums, v, m)) {
                return i;
            }
        }
        return latestStep;
    }

    private boolean check(int[] nums, int index, int m) {
        int contiousLeftOne = 0;
        int left = index - 1;
        while (left >= 0 && nums[left] == 1) {
            contiousLeftOne++;
            left--;
        }
        set.add(contiousLeftOne);
        int right = index + 1;
        int contiousRightOne = 0;
        while (right < nums.length && nums[right] == 1) {
            contiousRightOne++;
            right++;
        }
        set.add(contiousRightOne);
        set.remove(contiousLeftOne + contiousRightOne + 1);
        return set.contains(m);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        System.out.println(new P3LastestStep().findLatestStep(arr, 2));
    }
}
