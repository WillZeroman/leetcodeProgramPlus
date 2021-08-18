public class MovingCount {

    private int[][] directs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int movingCount(int m, int n, int k) {
        boolean[][] board = new boolean[m][n];

        return dfs(board, 0, 0, k);
    }

    private int dfs(boolean[][] board, int i, int j, int k) {
        if (sumBit(i) + sumBit(j) > k || board[i][j]) {
            return 0;
        }
        board[i][j] = true;
        int count = 1;
        for (int[] dir : directs) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (0 <= ii && ii < board.length && 0 <= jj && jj < board[0].length) {
                count +=dfs(board, ii, jj, k);
            }
        }
        return count;
    }

    private int sumBit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(3,2,1));
        System.out.println(new MovingCount().movingCount(3,1,0));
        System.out.println(new MovingCount().movingCount(3,2,17));
    }
}
