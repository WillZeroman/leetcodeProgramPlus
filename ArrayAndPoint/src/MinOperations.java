import java.util.ArrayDeque;
import java.util.Deque;

public class MinOperations {
    public int minOperations(String[] logs) {
        Deque<String> stack = new ArrayDeque<>();
        for (String log : logs) {
            if ("../".equals(log)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if ("./".equals(log)) {
                // do nothing;
            } else {
                stack.push(log);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(new MinOperations().minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
    }
}
