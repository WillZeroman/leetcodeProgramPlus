import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderSpaces {
    public String reorderSpaces(String text) {
        List<String> words = new ArrayList<>();
        String[] arr = text.split(" ");
        for (String s : arr) {
            if (!s.isEmpty()) {
                words.add(s.trim());
            }
        }
        int wordLength = words.stream().mapToInt(String::length).sum();
        int blackCount = text.length() - wordLength;
        StringBuilder ans = new StringBuilder();
        if (words.size() == 1) {
            ans.append(words.get(0));
            ans.append(genBlack(blackCount));
        } else {
            int mid = blackCount / (words.size() - 1);
            int remain = blackCount % (words.size() - 1);
            for (int i = 0; i < words.size(); i++) {
                ans.append(words.get(i));
                if (i != words.size() - 1) {
                    ans.append(genBlack(mid));
                }
            }
            ans.append(genBlack(remain));
        }
        return ans.toString();
    }

    private String genBlack(int count) {
        StringBuilder ans = new StringBuilder();
        while (count-- > 0) {
            ans.append(" ");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReorderSpaces().reorderSpaces("  this   is  a sentence "));
        System.out.println(new ReorderSpaces().reorderSpaces(" practice   makes   perfect"));
    }
}
