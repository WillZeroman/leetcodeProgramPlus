import java.util.Arrays;

public class FindCheapestPrice {

    private int ans = Integer.MAX_VALUE;

    /**
     * 有向图
     * dfs 超时
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        // init graph
        for (int[] flight : flights) {
            int flightSrc = flight[0];
            int flightDest = flight[1];
            graph[flightSrc][flightDest] = flight[2];
        }

        display(graph);
        boolean[] visited = new boolean[n];
        dfs(graph, visited, src, dst, k, 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int[][] graph, boolean[] visited, int src, int dst, int k, int cost) {
        if (src == dst) {
            ans = Math.min(cost, ans);
            return;
        }
        if (k < 0) {
            return;
        }

        if (cost>=ans){
            return;
        }
        visited[src] = true;
        int[] path = graph[src];
        for (int i = 0; i < path.length; i++) {
            if (path[i] > 0 && !visited[i]) {
                cost += path[i];
                dfs(graph, visited, i, dst, k - 1, cost);
                cost -= path[i];
            }
        }
        visited[src] = false;
    }

    private void display(int[][] data) {
        for (int[] arr : data) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
