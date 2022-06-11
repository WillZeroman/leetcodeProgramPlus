import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveOuterParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans.append(ch);
            }
            if (ch == '(') {
                stack.push(ch);
            }
        }
        return ans.toString();
    }


}
