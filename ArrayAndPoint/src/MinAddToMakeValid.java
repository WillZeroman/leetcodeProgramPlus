import java.util.ArrayDeque;
import java.util.Deque;

public class MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    ans++;
                } else {
                    stack.pop();
                }
            }
        }
        ans += stack.size();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinAddToMakeValid().minAddToMakeValid("())"));
        System.out.println(new MinAddToMakeValid().minAddToMakeValid("((("));
        System.out.println(new MinAddToMakeValid().minAddToMakeValid(""));
        System.out.println(new MinAddToMakeValid().minAddToMakeValid("()"));
        System.out.println(new MinAddToMakeValid().minAddToMakeValid("()))"));
    }
}
