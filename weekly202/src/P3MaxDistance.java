import java.util.Arrays;

public class P3MaxDistance {
    public int maxDistance(int[] position, int m) {
        if (m == 1) {
            return 0;
        }
        // sort
        Arrays.sort(position);
        if (m == 2) {
            return position[position.length - 1] - position[0];
        }
        boolean[] visited = new boolean[position.length];
        Arrays.fill(visited, false);
        visited[0] = true;
        visited[visited.length - 1] = true;
        int hasPos = 2;
        while (hasPos < m) {

            hasPos ++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] pos = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(new P3MaxDistance().maxDistance(pos, m));
    }
}
