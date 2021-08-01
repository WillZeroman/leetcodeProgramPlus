import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestoreArray {

    private List<Integer> max ;

    public int[] restoreArray(int[][] adjacentPairs) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<adjacentPairs.length;i++){
            int[] pair = adjacentPairs[i];
            set.add(pair[0]);
            set.add(pair[1]);
        }
        List<Integer> list = new ArrayList<>(set);
        int[][] graph = new int[list.size()][list.size()];
        for (int i = 0; i < adjacentPairs.length; i++) {
            int[] pair = adjacentPairs[i];
            int x = list.indexOf(pair[0]);
            int y = list.indexOf(pair[1]);
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        display(graph);

        List<Integer> ans = new ArrayList<>();
        int i=0;
        for (; i < graph.length; i++) {
            int[] g = graph[i];
            if(onlyOne(g)){
                break;
            }
        }
        System.out.println(i);
        ans.add(i);
        boolean[] visited = new boolean[graph.length];
        visited[i] = true;
        dfs(graph,visited,i,ans);
        int[] a = new int[list.size()];
        for (int j = 0; j < max.size(); j++) {
            a[j] = list.get(max.get(j));
        }
        return a;
    }

    private void dfs(int[][] graph, boolean[] visited, int i, List<Integer> ans) {
        if(ans.size() == graph.length){
            max = new ArrayList<>(ans);
            return;
        }
        int[] g = graph[i];
        for (int j = 0; j < g.length; j++) {
            if(g[j]==1&& !visited[j]){
                ans.add(j);
                visited[j]=true;
                dfs(graph,visited,j,ans);
                visited[j] = false;
                ans.remove(ans.size()-1);
            }
        }
    }

    private boolean onlyOne(int[] g) {
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            if(g[i] == 1){
                count ++;
            }
        }
        return count == 1;
    }

    private void display(int[][] data){
        for (int i = 0; i < data.length; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }


    public int[] restoreArray_best(int[][] adjacentPairs){
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int[] pair = adjacentPairs[i];
            List<Integer> list = map.getOrDefault(pair[0],new ArrayList<>());
            if(!list.contains(pair[1])){
                list.add(pair[1]);
            }
            map.put(pair[0],list);
            list = map.getOrDefault(pair[1],new ArrayList<>());
            if(!list.contains(pair[0])){
                list.add(pair[0]);
            }
            map.put(pair[1],list);
        }
        System.out.println(map);
        int start = -1;
        for(Integer key:map.keySet()){
            if(map.get(key).size()==1){
                start = key;
            }
        }
        System.out.println(start);
        int[] ans = new int[map.size()];
        ans[0] = start;
        Set<Integer> set = new HashSet<>();
        set.add(start);
        for(int i=1;i<ans.length;i++){
            List<Integer> list = map.get(ans[i-1]);
            for(int j=0;j<list.size();j++){
                if(!set.contains(list.get(j))){
                    set.add(list.get(j));
                    ans[i] = list.get(j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //[[4,-2],[1,4],[-3,1]]
        //[[2,1],[3,4],[3,2]]
        int[][] data = {{4,-2},{1,4},{-3,1}};
        System.out.println(Arrays.toString(new RestoreArray().restoreArray_best(data)));
    }
}
