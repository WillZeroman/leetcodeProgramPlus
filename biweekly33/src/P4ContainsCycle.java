/**
 * 5482. 二维网格图中探测环
 *
 * 1） dfs 判断环， 超时
 * 2）并查集
 */
public class P4ContainsCycle {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    int[] lastPos = {-1, -1};
                    if (dfs(visited, grid, i, j, lastPos)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] visited, char[][] grid, int i, int j, int[] lastPos) {
        int m = grid.length;
        int n = grid[0].length;
        char ch = grid[i][j];
        //check circle;
        if (visited[i][j]) {
            if ((i - 1 == lastPos[0] && j == lastPos[1])) {
                return false;
            } else {
                return true;
            }
        }
        visited[i][j] = true;
        int[] tempLastPos = {i, j};
        if (i - 1 >= 0 && ch == grid[i - 1][j] && !(i - 1 == lastPos[0] && j == lastPos[1])) {
            if (dfs(visited, grid, i - 1, j, tempLastPos)) {
                return true;
            }
        }
        if (i + 1 < m && ch == grid[i + 1][j] && !(i + 1 == lastPos[0] && j == lastPos[1])) {
            if (dfs(visited, grid, i + 1, j, tempLastPos)) {
                return true;
            }
        }
        if (j - 1 >= 0 && ch == grid[i][j - 1] && !(i == lastPos[0] && j - 1 == lastPos[1])) {
            if (dfs(visited, grid, i, j - 1, tempLastPos)) {
                return true;
            }
        }
        if (j + 1 < n && ch == grid[i][j + 1] && !(i == lastPos[0] && j + 1 == lastPos[1])) {
            if (dfs(visited, grid, i, j + 1, tempLastPos)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        //char[][] grid = {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        char[][] grid = {{'b', 'b'}, {'b', 'b'}};
        System.out.println(new P4ContainsCycle().containsCycle(grid));
    }

}
