public class minCost {
    public int minCostConnectPoints(int[][] points) {
        if (points.length == 1) {
            return 0;
        }
        int[][] maxPoints = new int[2][2];
        double[] maxValue = new double[2];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            double value = Math.pow(point[0], 2) + Math.pow(point[1], 2);
            if (value > maxValue[0]) {
                maxValue[1] = maxValue[0];
                maxPoints[1] = maxPoints[0];
                maxValue[0] = value;
                maxPoints[0] = point;
            } else if (value > maxValue[1]) {
                maxValue[1] = value;
                maxPoints[1] = point;
            }
        }

        int sum = 0;
        for (int i = 0; i < maxPoints.length; i++) {
            int[] point = maxPoints[i];
            int tmp = Math.abs(point[0]) + Math.abs(point[1]);
            sum += tmp;
        }
        return sum;
    }
}
