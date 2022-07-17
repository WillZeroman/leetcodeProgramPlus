import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        return Arrays.stream(words).filter(word -> match(word, pattern) && match(pattern, word)).collect(Collectors.toList());
    }

    private boolean match(String word, String pattern) {
        if (word.equals(pattern)) {
            return true;
        }
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < word.length(); ++i) {
            char x = word.charAt(i), y = pattern.charAt(i);
            if (!map.containsKey(x)) {
                map.put(x, y);
            } else if (map.get(x) != y) { // word 中的同一字母必须映射到 pattern 中的同一字母上
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //["abc","deq","mee","aqq","dkd","ccc"]
        //"abb"
        System.out.println(new FindAndReplacePattern().findAndReplacePattern(new String[]{"abc",
                "deq", "mee", "aqq", "dkd", "ccc"}, "qwe"));
        System.out.println(new FindAndReplacePattern().findAndReplacePattern(new String[]{"abc",
                "cba", "xyx", "yxx", "yyx"}, "abc"));
    }
}
