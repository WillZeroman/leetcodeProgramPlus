import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先算法
 * 深度优先算法
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        boolean[][] visited = new boolean[image.length][image[0].length];
        Point p = new Point(sr, sc);
        int color = image[sr][sc];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);
        while (!queue.isEmpty()) {
            Point tempPoint = queue.poll();
            image[tempPoint.row][tempPoint.col] = newColor;
            if (tempPoint.row - 1 >= 0 && !visited[tempPoint.row - 1][tempPoint.col]
                    && image[tempPoint.row - 1][tempPoint.col] == color) {
                queue.offer(new Point(tempPoint.row - 1, tempPoint.col));
            }
            if (tempPoint.col - 1 >= 0 && !visited[tempPoint.row][tempPoint.col - 1]
                    && image[tempPoint.row][tempPoint.col - 1] == color) {
                queue.offer(new Point(tempPoint.row, tempPoint.col - 1));
            }
            if (tempPoint.col + 1 < col && !visited[tempPoint.row][tempPoint.col + 1]
                    && image[tempPoint.row][tempPoint.col + 1] == color) {
                queue.offer(new Point(tempPoint.row, tempPoint.col + 1));
            }
            if (tempPoint.row + 1 < row && !visited[tempPoint.row + 1][tempPoint.col]
                    && image[tempPoint.row + 1][tempPoint.col] == color) {
                queue.offer(new Point(tempPoint.row + 1, tempPoint.col));
            }

            visited[tempPoint.row][tempPoint.col] = true;
        }
        return image;
    }

    public static void display(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }

    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };
        display(image);
        new FloodFill().floodFill(image, 1, 1, 2);
        display(image);
    }
}
