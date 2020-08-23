import java.util.*;

public class P2FindSmallectSetVertices {
    /**
     * 入度为0的店
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> tmpEdge = edges.get(i);
            set.remove(tmpEdge.get(1));
        }
        List<Integer> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {

    }
}
