import java.util.*;

public class Evaluate {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder ans = new StringBuilder();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                start = i+1;
            } else if (ch == ')') {
                String tmp = s.substring(start,i);
                if(map.containsKey(tmp)){
                    ans.append(map.get(tmp));
                }else {
                    ans.append("?");
                }
                start = 0;
            } else {
                if(start==0){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("name","bob"));
        list.add(Arrays.asList("age","two"));
        System.out.println(new Evaluate().evaluate("(name)is(age)yearsold", list));
        list = new ArrayList<>();
        list.add(Arrays.asList("a","yes"));
        System.out.println(new Evaluate().evaluate("(a)(a)(a)aaa", list));
    }
}
