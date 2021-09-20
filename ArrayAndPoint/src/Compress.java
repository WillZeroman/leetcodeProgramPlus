import java.util.Arrays;

public class Compress {
    public int compress(char[] chars) {
        int write = 0;
        int left = 0;
        for (int k = 0; k < chars.length; k++) {
            char ch = chars[k];
            if (k == chars.length - 1 || ch != chars[k + 1]) {
                int count = k - left + 1;
                chars[write] = ch;
                write++;
                if (count > 1) {
                    String str = String.valueOf(count);
                    for (int m = 0; m < str.length(); m++) {
                        chars[write] = str.charAt(m);
                        write++;
                    }
                }
                left = k + 1;
            }
        }
        int ans = write;
        for (; write < chars.length; write++) {
            chars[write] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abbbbbbbbbbc";
        char[] data = s.toCharArray();
        System.out.println(new Compress().compress(data));
        System.out.println(Arrays.toString(data));
    }
}
