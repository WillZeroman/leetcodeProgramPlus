import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0],item[1]);
        }
        for (int[] item : items2) {
            int weight = map.getOrDefault(item[0],0);
            map.put(item[0],weight + item[1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Integer key:map.keySet()){
            int weight = map.get(key);
            List<Integer> list = new ArrayList<>();
            list.add(key);
            list.add(weight);
            ans.add(list);
        }
        Collections.sort(ans, Comparator.comparingInt(o -> o.get(0)));
        return ans;
    }
}
