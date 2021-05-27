import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseParentheses {
    public String reverseParentheses(String s) {
        if(s.length() == 0){
            return s;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        StringBuilder ans = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
              stack.push(i);
            } else if(ch == ')'){
                int start =stack.pop();
                String tmpStr = new StringBuilder(ans.substring(start+1,i)).reverse().toString();
                ans.replace(start+1,i,tmpStr);
            }
        }
        return ans.toString().replace("(","").replace(")","");
    }

    public String reverseParentheses_best(String s){
        if(s.length() == 0){
            return s;
        }
        Deque<String> stack = new ArrayDeque<String>();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ans.toString());
                ans.setLength(0);
            } else if(ch == ')'){
                ans.reverse();
                ans.insert(0,stack.pop());
            }else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseParentheses().reverseParentheses("(abcd)"));
        System.out.println(new ReverseParentheses().reverseParentheses_best("(u(love)i)"));
        System.out.println(new ReverseParentheses().reverseParentheses_best("(ed(et(oc))el)"));
        System.out.println(new ReverseParentheses().reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
