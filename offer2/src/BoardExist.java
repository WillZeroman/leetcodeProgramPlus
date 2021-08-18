public class BoardExist {

    private int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char ch = board[i][j];
                if (ch == word.charAt(0)) {
                    boolean[][] visited = new boolean[row][col];
                    if (dfs(board, visited, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        char ch = board[i][j];
        if (ch != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int row = board.length;
        int col = board[0].length;
        for (int[] dir : direct) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (0 <= ii && ii < row && 0 <= jj && jj < col && !visited[ii][jj]) {
                if (dfs(board, visited, ii, jj, word, index + 1)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        //[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        //"ABCCED"
        //[["a","b"],["c","d"]], word = "abcd"
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new BoardExist().exist(board,"ABCCED"));
        char[][] board1 = {{'a', 'b'}, {'c', 'd'}};
        System.out.println(new BoardExist().exist(board1, "abcd"));
    }

}
