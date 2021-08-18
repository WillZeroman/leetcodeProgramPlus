import java.util.Arrays;

public class FindPaths {
    private int ans;

    private int div = 1000000000 + 7;
    private int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove == 0){
            return 0;
        }
        dfs(m,n,maxMove,startRow,startColumn);
        return ans;
    }

    private void dfs(int m, int n, int maxMove, int row, int column) {
        if(row<0||row>=m||column<0||column>=n){
            ans ++;
            ans %= div;
            return;
        }
        //
        if(maxMove == 0){
            return;
        }
        for(int[] dir:directions){
            dfs(m,n,maxMove -1,row+dir[0],column+dir[1]);
        }
    }

    public int findPaths_DP(int m, int n, int maxMove, int startRow, int startColumn){
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int ans = 0;
        for(int k=0;k<maxMove;k++){
            int[][] dpNew = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int count = dp[i][j];
                    if(count >0){
                        for(int[] dir:directions){
                            int newI=i+dir[0];
                            int newJ= j+dir[1];
                            if(0<=newI&&newI<m&&0<=newJ&&newJ<n){
                                dpNew[newI][newJ]= (count + dpNew[newI][newJ])%div;
                            } else {
                                ans = (ans + count)%div;
                            }
                        }
                    }
                }
            }
            for(int[] data:dpNew){
                System.out.println(Arrays.toString(data));
            }
            dp = dpNew;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindPaths().findPaths(2,2,2,0,0));
        System.out.println(new FindPaths().findPaths_DP(2,2,2,0,0));
        System.out.println(new FindPaths().findPaths(2,2,3,0,0));
        System.out.println(new FindPaths().findPaths_DP(2,2,3,0,0));
        System.out.println(new FindPaths().findPaths(1,3,3,0,1));
        System.out.println(new FindPaths().findPaths_DP(1,3,3,0,1));
    }
}
