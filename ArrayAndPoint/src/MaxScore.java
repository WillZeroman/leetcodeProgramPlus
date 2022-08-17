public class MaxScore {
    public int maxScore(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                right++;
            }
        }
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '0') {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, left + right);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxScore().maxScore("00111"));
        System.out.println(new MaxScore().maxScore("011101"));
        System.out.println(new MaxScore().maxScore("01"));
        System.out.println(new MaxScore().maxScore("00"));
    }
}
