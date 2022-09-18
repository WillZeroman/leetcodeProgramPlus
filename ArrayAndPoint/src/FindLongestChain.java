import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        int curr = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindLongestChain().findLongestChain(new int[][]{{1,2},{2,3},{2,4},{3,4},{4,5}}));
        System.out.println(new FindLongestChain().findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}}));
        System.out.println(new FindLongestChain().findLongestChain(new int[][]{{7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3}}));
    }
}
