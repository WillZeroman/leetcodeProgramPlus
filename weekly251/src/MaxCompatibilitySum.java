import java.util.Arrays;

public class MaxCompatibilitySum {

    private int ans =0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m= students.length;
        int n = students[0].length;
        int[][] arrSum = new int[m][m];
        for(int i = 0;i<m;i++){
            int[] student = students[i];
            for(int j=0;j<m;j++){
                int[] mentor = mentors[j];
                //xor
                int sum = 0;
                for(int k=0;k<n;k++){
                    sum += (student[k]==mentor[k]?1:0);
                }
                arrSum[i][j]=sum;
            }
        }
        for(int i=0;i<m;i++){
            System.out.println(Arrays.toString(arrSum[i]));
        }

        // back-cursor
        boolean[] visited = new boolean[m];
        dfs(arrSum,0,visited,0);
        return ans;
    }

    private void dfs(int[][] arrSum, int index,boolean[] visited,int sum) {
        if(index >=arrSum.length){
            ans = Math.max(sum,ans);
        }
        for(int i=0;i<arrSum.length;i++){
            if(!visited[i]){
                visited[i] = true;
                sum +=arrSum[index][i];
                dfs(arrSum,index+1,visited,sum);
                visited[i] = false;
                sum -=arrSum[index][i];
            }
        }
    }

    public static void main(String[] args) {
        //[[1,1,0],[1,0,1],[0,0,1]]
        //[[1,0,0],[0,0,1],[1,1,0]]
        int[][] stus = {{1,1,0},{1,0,1},{0,0,1}};
        int[][] mentros = {{1,0,0},{0,0,1},{1,1,0}};
        System.out.println(new MaxCompatibilitySum().maxCompatibilitySum(stus,mentros));
    }
}
