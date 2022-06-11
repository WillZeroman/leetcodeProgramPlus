import java.util.Arrays;

public class DiStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int min = 0;
        int max = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'I') {
                ans[i] = min;
                min++;
            } else {
                ans[i] = max;
                max--;
            }
        }
        ans[n] = min;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DiStringMatch().diStringMatch("DIDI")));
        System.out.println(Arrays.toString(new DiStringMatch().diStringMatch("III")));
        System.out.println(Arrays.toString(new DiStringMatch().diStringMatch("IDID")));
    }
}
