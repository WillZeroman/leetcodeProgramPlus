import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cursor = i;
            List<Integer> list = new ArrayList<>();
            while (!visited.contains(cursor)) {
                list.add(cursor);
                visited.add(cursor);
                cursor = nums[cursor];
            }
            for (int j = 0; j < list.size(); j++) {
                int currentLength = list.size() - j;
                int nextLenth = map.getOrDefault(list.get(list.size() - 1), 1);
                map.put(list.get(j), currentLength + nextLenth -1);
            }
        }
        System.out.println(map);
        return map.values().stream().max(Comparator.comparingInt(Integer::intValue)).get();
    }

    public int arrayNesting_best(int[] nums) {
        int ans = 0, n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            while (!vis[i]) {
                vis[i] = true;
                i = nums[i];
                ++cnt;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayNesting().arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }
}
