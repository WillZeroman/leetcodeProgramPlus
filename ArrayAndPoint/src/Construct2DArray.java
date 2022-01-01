import java.util.Arrays;

public class Construct2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m * n){
            return new int[0][0];
        }
        int[][] ans = new int[m][n];
        for (int i=0; i*n<original.length; i++) {
            int from = i* n;
            int to = (i+1)*n;
            ans[i] = Arrays.copyOfRange(original,from,to);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] ans = new Construct2DArray().construct2DArray(new int[]{1,2,3,4},2,2);
        display(ans);
        ans = new Construct2DArray().construct2DArray(new int[]{1,2,3},1,3);
        display(ans);
        ans = new Construct2DArray().construct2DArray(new int[]{1,2},1,1);
        display(ans);
    }

    private static void display(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }
}
