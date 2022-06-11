package rectpick;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private int[][] rects;
    private int rectSize;

    private Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.rectSize = rects.length;
        this.random = new Random();
    }

    public int[] pick() {
        int[] rect = rects[random.nextInt(rectSize)];
        int difX = rect[2] - rect[0];
        int difY = rect[3] - rect[1];
        int randX = random.nextInt(difX + 1);
        int randY = random.nextInt(difY + 1);
        return new int[]{rect[0] + randX, rect[1] + randY};
    }

    public static void main(String[] args) {
        int[][] rects = {{-2, -2, 1, 1},{2, 2, 4, 6}};
        Solution obj = new Solution(rects);
        for(int i=0;i<10;i++){
            System.out.println(Arrays.toString(obj.pick()));
        }
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
    }
}
