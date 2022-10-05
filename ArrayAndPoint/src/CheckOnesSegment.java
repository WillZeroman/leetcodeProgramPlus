public class CheckOnesSegment {
    public boolean checkOnesSegment(String s) {
        boolean ans = true;
        boolean notExistOne = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                notExistOne = true;
            } else {
                if (notExistOne) {
                    ans = false;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CheckOnesSegment().checkOnesSegment("1001"));
        System.out.println(new CheckOnesSegment().checkOnesSegment("110"));
        System.out.println(new CheckOnesSegment().checkOnesSegment("1101"));
    }
}
