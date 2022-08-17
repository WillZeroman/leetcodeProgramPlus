import java.util.ArrayList;
import java.util.List;

public class StringMatching {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String subString = words[i];
            for (int j = 0; j < words.length; j++) {
                if (j != i) {
                    String targetString = words[j];
                    if (targetString.contains(subString)) {
                        ans.add(subString);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new StringMatching().stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}));
        System.out.println(new StringMatching().stringMatching(new String[]{"leetcode", "et",
                "code"}));
        System.out.println(new StringMatching().stringMatching(new String[]{"blue", "green",
                "bu"}));
    }
}
