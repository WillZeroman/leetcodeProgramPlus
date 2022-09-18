import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxEqualFreq {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
            if (checkValid(map)) {
                ans = Math.max(ans, i + 1);
            }
        }
        return ans;
    }

    private boolean checkValid(Map<Integer, Integer> map) {
        Map<Integer,Integer> set = new HashMap<>();
        for (int value : map.values()) {
            int count = map.getOrDefault(value,0);
            count ++;
            set.put(value,count);
            if (set.size() > 2) {
                return false;
            }
        }
        if (set.size() == 0 || set.size() == 1) {
            return true;
        }
        List<Integer> list = new ArrayList<>(set.values());
        return !(list.get(0)>1 && list.get(1)>1);
    }

    public int maxEqualFreq_best(int[] nums){
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count.getOrDefault(nums[i], 0) > 0) {
                freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
            }
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(nums[i]));
            freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);
            boolean ok = maxFreq == 1 ||
                    freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 ||
                    freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;
            if (ok) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(new MaxEqualFreq().maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}));
        //System.out.println(new MaxEqualFreq().maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5}));
        System.out.println(new MaxEqualFreq().maxEqualFreq_best(new int[]{10,2,8,9,3,8,1,5,2,3,7,6}));
    }
}
