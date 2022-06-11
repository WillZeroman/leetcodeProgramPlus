package randpoint;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    private double radius;
    private double x;
    private double y;

    private Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x = x_center;
        this.y = y_center;
        this.random = new Random();
    }

    public double[] randPoint() {
        while (true) {
            double xDiff = random.nextDouble() * (2 * radius) - radius;
            double yDiff = random.nextDouble() * (2 * radius) - radius;
            if (xDiff * xDiff + yDiff * yDiff <= radius * radius) {
                return new double[]{xDiff + x, yDiff + y};
            }
        }
    }

    public static void main(String[] args) {
        /**
         * Your Solution object will be instantiated and called as such:
         * Solution obj = new Solution(radius, x_center, y_center);
         * double[] param_1 = obj.randPoint();
         */
        Solution obj = new Solution(1.0, 0.0, 0.0);
        for(int i=0;i<1;i++){
            double[] param_1 = obj.randPoint();
            System.out.println(Arrays.toString(param_1));
        }
    }
}
