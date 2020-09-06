package reverseword;

public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' '){
                sb.append(tempSb.reverse()).append(ch);
                tempSb = new StringBuilder();
            }else {
                tempSb.append(ch);
            }
        }
        sb.append(tempSb.reverse());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("abcd"));
        System.out.println(new ReverseWords().reverseWords("Let's take LeetCode contest"));
    }
}
