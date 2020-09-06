import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1ContainsPattern {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (arr.length < m * k) {
            return false;
        }
        Map<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> tempList = new ArrayList<>(m);
        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (j < m) {
                tempList.add(arr[i]);
            } else {
                int count = map.getOrDefault(tempList, 0);
                map.put(tempList, count + 1);
                tempList = new ArrayList<>();
                tempList.add(arr[i]);
                j = 0;
                if (count >= k - 1) {
                    return true;
                }
            }
        }
        if (tempList.size() == m) {
            int count = map.getOrDefault(tempList, 0);
            if (count >= k - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,2,2,1,1,1,2,1};
        System.out.println(new P1ContainsPattern().containsPattern(arr, 2, 2));
    }
}
