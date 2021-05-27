package dp;

import java.util.Arrays;

public class MaxValue {
    public int maxValue(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        ans[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            ans[i][0] = grid[i][0] + ans[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            ans[0][i] = grid[0][i] + ans[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - 1]) + grid[i][j];
            }
        }
        display(ans);
        return ans[grid.length - 1][grid[0].length - 1];
    }

    private void display(int[][] data){
        for(int i=0;i<data.length;i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MaxValue().maxValue(grid));
        int[][] grid1 = {{1,2,5},{3,2,1}};
        System.out.println(new MaxValue().maxValue(grid1));
    }
}
