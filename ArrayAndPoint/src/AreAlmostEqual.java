import java.util.ArrayList;
import java.util.List;

public class AreAlmostEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return true;
        }
        if (list.size() == 2) {
            if (s1.charAt(list.get(0)) == s2.charAt(list.get(1)) && s1.charAt(list.get(1)) == s2.charAt(list.get(0))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
