import java.util.Arrays;

public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 1; i < s.length(); i++) {
                String temp = s.substring(i) + s.substring(0, i);
                if (ans.compareTo(temp) > 0) {
                    ans = temp;
                }
            }
            return ans;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }

    public static void main(String[] args) {
        System.out.println(new OrderlyQueue().orderlyQueue("cba",1));
        System.out.println(new OrderlyQueue().orderlyQueue("baaca",3));
    }
}
