import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountMatches {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> map = new HashMap<>();
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);
        int idx = map.get(ruleKey);
        int ans = 0;
        for (List<String> item:items) {
            if (item.get(idx).equals(ruleValue)) {
                ans ++;
            }
        }
        return ans;
    }
}
