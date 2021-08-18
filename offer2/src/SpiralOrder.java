import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = matrix.length;
        int col = matrix[0].length;
        int max = row * col;
        int count = 0;
        int[] ans = new int[max];
        int i = 0;
        int j = 0;
        int dirIndex = 0;
        Set<Integer> visitedI = new HashSet<>();
        Set<Integer> visitedJ = new HashSet<>();
        while (count < max) {
            int num = matrix[i][j];
            ans[count] = num;
            count++;
            int nextI = i + directs[dirIndex][0];
            int nextJ = j + directs[dirIndex][1];
            if (visitedI.contains(nextI) || visitedJ.contains(nextJ)
                    || nextI >= row || nextI < 0 || nextJ < 0 || nextJ >= col) {
                if (dirIndex == 0 || dirIndex == 2) {
                    visitedI.add(i);
                } else {
                    visitedJ.add(j);
                }
                dirIndex = (dirIndex + 1 + directs.length) % directs.length;
                System.out.println(i + " " + j);
            }
            i += directs[dirIndex][0];
            j += directs[dirIndex][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        //[[1,2,3],[4,5,6],[7,8,9]]
        int[][] data = {{1, 2, 3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(Arrays.toString(new SpiralOrder().spiralOrder(data)));
    }

}
