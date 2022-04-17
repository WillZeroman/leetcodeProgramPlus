import java.util.LinkedList;
import java.util.Queue;

public class ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        int[] target = new int[]{tx, ty};
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int res = compare(data, target);
            if (res == 0) {
                return true;
            } else if (res < 0) {
                queue.offer(new int[]{data[0], data[0] + data[1]});
                queue.offer(new int[]{data[0] + data[1], data[1]});
            } else {
                // do nothing
            }
        }
        return false;
    }

    public int compare(int[] a1, int[] a2) {
        if ((a1[0] < a2[0] && a1[1] < a2[1])
                || (a1[0] == a2[0] && a1[1] < a2[1])
                || (a1[0] < a2[0] && a1[1] == a2[1])) {
            return -1;
        } else if (a1[0] == a2[0] && a1[1] == a2[1]) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReachingPoints().reachingPoints(1,1,3,5));
        System.out.println(new ReachingPoints().reachingPoints(1,1,2,2));
        System.out.println(new ReachingPoints().reachingPoints(1,1,1,1));
    }
}
