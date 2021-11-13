public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        while (left < row && right >= 0) {
            if (matrix[left][right] < target) {
                left++;
            } else if (matrix[left][right] > target) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
