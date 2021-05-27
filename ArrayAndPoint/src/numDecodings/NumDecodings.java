package numDecodings;

public class NumDecodings {

    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] ans = new int[s.length()+1];
        ans[0] = 1;
        for (int i = 1; i < s.length()+1; i++) {
            if (s.charAt(i - 1) != '0') {
                ans[i] += ans[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                ans[i] += ans[i - 2];
            }
        }
        return ans[s.length()];
    }

    private boolean isValid(char current, char preChar) {
        if (current == '0' || preChar == '0') {
            return false;
        }
        String s = preChar + "" + current;
        int num = Integer.parseInt(s);
        return num <= 26;
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("226"));
        System.out.println(new NumDecodings().numDecodings("12"));
        System.out.println(new NumDecodings().numDecodings("0"));
        System.out.println(new NumDecodings().numDecodings("06"));
        System.out.println(new NumDecodings().numDecodings("1126"));
        System.out.println(new NumDecodings().numDecodings("2101"));
    }
}
