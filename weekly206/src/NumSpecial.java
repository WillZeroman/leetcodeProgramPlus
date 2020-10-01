public class NumSpecial {
    public int numSpecial(int[][] mat) {
        int[] row = new int[mat.length];
        int[] column = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    row[i] += 1;
                    column[j] += 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && column[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
