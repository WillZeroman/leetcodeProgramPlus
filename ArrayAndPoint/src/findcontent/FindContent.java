package findcontent;

import java.util.Arrays;

public class FindContent {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(new FindContent().findContentChildren(g, s));
        g = new int[]{1,2};
        s = new int[]{1,2,3};
        System.out.println(new FindContent().findContentChildren(g, s));
    }
}
