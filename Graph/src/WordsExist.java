/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 */
public class WordsExist {

    private int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * 方法一： DFS
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isSameChar(first, board[i][j])) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        // same and visit all charactor return true
        if (index == word.length() - 1 && isSameChar(word.charAt(index), board[i][j])) {
            return true;
        }
        // not same return false
        if (!isSameChar(word.charAt(index), board[i][j])) {
            return false;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int k = 0; k < direct.length; k++) {
            int[] dir = direct[k];
            if (valid(i + dir[0], j + dir[1], board.length, board[0].length) && !visited[i + dir[0]][j + dir[1]]) {
                res |= dfs(board, word, index + 1, i + dir[0], j + dir[1], visited);
                // 如果为 true 返回，避免往后递归
                if(res){
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return res;
    }

    private boolean valid(int i, int j, int row, int column) {
        return 0 <= i && i < row && 0 <= j && j < column;
    }

    private boolean isSameChar(char first, char second) {
        return Character.compare(first,second) == 0;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new WordsExist().exist(board, "SEE"));
    }

}
