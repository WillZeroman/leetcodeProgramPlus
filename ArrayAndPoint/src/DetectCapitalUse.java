public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        boolean firstUpper = false;
        int upperCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (i == 0 && Character.isUpperCase(ch)) {
                firstUpper = true;
            }
            if (Character.isUpperCase(ch)) {
                upperCount++;
            }
        }
        if (firstUpper) {
            return upperCount == 1 || upperCount == word.length();
        } else {
            return upperCount == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new DetectCapitalUse().detectCapitalUse("USA"));
        System.out.println(new DetectCapitalUse().detectCapitalUse("leetcode"));
        System.out.println(new DetectCapitalUse().detectCapitalUse("Test"));
        System.out.println(new DetectCapitalUse().detectCapitalUse("TesG"));
        System.out.println(new DetectCapitalUse().detectCapitalUse("tesG"));
    }
}
