import java.util.ArrayList;
import java.util.List;

public class Reformat {
    public String reformat(String s) {
        List<Character> digitList = new ArrayList<>();
        List<Character> abcList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                digitList.add(ch);
            } else {
                abcList.add(ch);
            }
        }
        if (Math.abs(digitList.size() - abcList.size()) > 1) {
            return "";
        }
        List<Character> first = digitList.size() > abcList.size() ? digitList : abcList;
        List<Character> second = digitList.size() > abcList.size() ? abcList : digitList;
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < second.size()) {
            ans.append(first.get(i));
            ans.append(second.get(i));
            i++;
        }
        if (i < first.size()) {
            ans.append(first.get(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Reformat().reformat("a0b1c2"));
        System.out.println(new Reformat().reformat("leetcode"));
        System.out.println(new Reformat().reformat("123"));
        System.out.println(new Reformat().reformat("123abcd"));
        System.out.println(new Reformat().reformat("12345abcd"));
    }
}
