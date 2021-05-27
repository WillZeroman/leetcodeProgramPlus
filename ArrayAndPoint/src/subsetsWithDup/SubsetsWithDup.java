package subsetsWithDup;

import java.util.*;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> map = new HashSet<>();
        int maxValue = 1 << nums.length;
        for (int i = 0; i < maxValue; i++) {
            String tempStr = Long.toBinaryString(i);
            StringBuilder sb = new StringBuilder(tempStr);
            while (sb.length() < nums.length) {
                sb.insert(0, "0");
            }
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j<sb.length(); j++) {
                char ch = sb.charAt(j);
                if (ch == '1') {
                    set.add(nums[j]);
                }
            }
            String key = set.toString();
            if(!map.contains(key)){
                result.add(set);
                map.add(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1,2,2}));
    }
}
