public class CheckStraightLine {


    public boolean checkStraightLine(int[][] coordinates) {
        int diffX = coordinates[1][0] - coordinates[0][0];
        int diffY = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            int tempDiffX = coordinates[i][0] - coordinates[i - 1][0];
            int tempDiffY = coordinates[i][1] - coordinates[i - 1][1];
            if (tempDiffX * diffY == tempDiffY * diffX) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
        int[][] nums = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        System.out.println(new CheckStraightLine().checkStraightLine(nums));
    }
}
