import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        int maxValue = 1 << nums.length;
        for (int i = 0; i < maxValue; i++) {
            String tempStr = Long.toBinaryString(i);
            StringBuilder sb = new StringBuilder(tempStr);
            while (sb.length() < nums.length) {
                sb.insert(0, "0");
            }
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < sb.length(); j++) {
                char ch = sb.charAt(j);
                if (ch == '1') {
                    set.add(nums[j]);
                }
            }
            result.add(set);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Subset().subsets(nums));
    }
}
