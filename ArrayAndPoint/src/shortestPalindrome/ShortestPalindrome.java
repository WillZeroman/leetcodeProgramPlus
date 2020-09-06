package shortestPalindrome;

/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * <p>
 * 分析：给定字符串找最长回文子串·                                                                                     ·····
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        //
        int len = s.length();
        for (int i = len; i > 0; i--) {
            if (isPalindrome(s.substring(0, i))) {
                if (len - i > 0) {
                    StringBuilder sb = new StringBuilder(s.substring(i, len));
                    sb.reverse().append(s);
                    return sb.toString();
                } else {
                    return s;
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse().append(s.substring(1));
        return sb.toString();
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPalindrome().shortestPalindrome("aacecaaa"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("abcd"));
    }
}
