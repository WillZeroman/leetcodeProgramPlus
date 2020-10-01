import java.util.HashMap;
import java.util.Map;

public class UnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        //convert pairs to graph
        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            int[] pair = pairs[i];
            pairMap.put(pair[0], pair[1]);
            pairMap.put(pair[1], pair[0]);
        }
        //convert preferences
        Map<Integer, Integer>[] preferenceMap = new HashMap[n];
        for (int i = 0; i < preferences.length; i++) {
            int[] preference = preferences[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < preference.length; j++) {
                map.put(preference[j], n - j);
            }
            preferenceMap[i] = map;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (unhappy(n, preferenceMap, pairMap, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean unhappy(int n, Map<Integer, Integer>[] preferences, Map<Integer, Integer> pairMap, int friend) {
        Map<Integer, Integer> preferMap = preferences[friend];
        int pairFriend = pairMap.get(friend);
        int pairValue = preferMap.get(pairFriend);
        if (pairValue < n) {
            for (Integer key : preferMap.keySet()) {
                if (preferMap.get(key) > pairValue) {
                    Map<Integer, Integer> uPreferMap = preferences[key];
                    int v = pairMap.get(key);
                    if (uPreferMap.get(friend) > uPreferMap.get(v)) {
                        System.out.println(friend);
                        return true;
                    }
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] prefer = {{1,2,3},{3,2,0},{3,1,0},{1,2,0}};
        int[][] pair = {{0,1},{2,3}};
        System.out.println(new UnhappyFriends().unhappyFriends(4,prefer,pair));
    }
}
