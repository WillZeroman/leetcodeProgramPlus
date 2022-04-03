import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuckyNumbers {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] data = matrix[i];
            sets.add(Arrays.stream(data).min().getAsInt());
        }
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int max = matrix[0][i];
            for (int j = 1; j < m; j++) {
                max = Math.max(max,matrix[j][i]);
            }
            if(sets.contains(max)){
                ans.add(max);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LuckyNumbers().luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}}));
    }
}
