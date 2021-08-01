package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            byte[] tmp = str.getBytes();
            Arrays.sort(tmp);
            String newStr = new String(tmp);
            List<String> list = map.getOrDefault(newStr, new ArrayList<>());
            list.add(str);
            map.putIfAbsent(newStr, list);
        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }
}
