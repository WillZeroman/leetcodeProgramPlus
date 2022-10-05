public class IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s2+s2).contains(s1);
    }
}
