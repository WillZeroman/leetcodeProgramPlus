import java.util.Arrays;

public class NumSpecial {
    public int numSpecial(int[][] mat) {
        boolean[] rowFlag = new boolean[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            rowFlag[i] = Arrays.stream(row).sum() == 1;
        }
        int column = mat[0].length;
        boolean[] columnFlag = new boolean[column];
        for (int i = 0; i < column; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum += mat[j][i];
            }
            columnFlag[i] = sum == 1;
        }
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && rowFlag[i] && columnFlag[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumSpecial().numSpecial(new int[][]{{1,0,0},{0,0,1},{1,0,0}}));
        System.out.println(new NumSpecial().numSpecial(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
        System.out.println(new NumSpecial().numSpecial(new int[][]{{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,1},{0,0,0,0,1,0,0,0},{1,0,0,0,1,0,0,0},{0,0,1,1,0,0,0,0}}));
    }
}
