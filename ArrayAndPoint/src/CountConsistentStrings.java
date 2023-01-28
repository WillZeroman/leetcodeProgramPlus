import java.util.HashSet;
import java.util.Set;

public class CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int ans = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length() && flag; i++) {
                char ch = word.charAt(i);
                flag = set.contains(ch);
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountConsistentStrings().countConsistentStrings("ab",new String[]{"ad","bd","aaab","baa","badab"}));
    }
}
