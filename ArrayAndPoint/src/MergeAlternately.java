public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int len = Math.min(word1.length(), word2.length());
        for (int i = 0; i < len; i++) {
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
        }
        if (word1.length() > len) {
            ans.append(word1.substring(len));
        }
        if (word2.length() > len) {
            ans.append(word2.substring(len));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MergeAlternately().mergeAlternately("abc","pqr"));
        System.out.println(new MergeAlternately().mergeAlternately("abc","p"));
        System.out.println(new MergeAlternately().mergeAlternately("ab","pqrasdf"));
    }
}
