import java.util.HashMap;
import java.util.Map;

public class MaxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int previous = map.get(ch);
                int distance = i - previous - 1;
                max = Math.max(max, distance);
            } else {
                map.put(ch, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxLengthBetweenEqualCharacters().maxLengthBetweenEqualCharacters("aa"));
        System.out.println(new MaxLengthBetweenEqualCharacters().maxLengthBetweenEqualCharacters("abcd"));
        System.out.println(new MaxLengthBetweenEqualCharacters().maxLengthBetweenEqualCharacters("abcda"));
    }
}
