import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    List<String> list = new ArrayList<>();

    public String[] permutation(String s) {
        int size = s.length();
        StringBuilder strBuilder = new StringBuilder();
        boolean[] visited = new boolean[size];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        dfs(arr, 0, visited, strBuilder);
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void dfs(char[] arr, int i, boolean[] visited, StringBuilder strBuilder) {
        if (i == arr.length) {
            list.add(strBuilder.toString());
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (visited[j] || j > 0 && !visited[j-1] && arr[j - 1] == arr[j]) {
                continue;
            }
            if (!visited[j]) {
                visited[j] = true;
                strBuilder.append(arr[j]);
                dfs(arr, i + 1, visited, strBuilder);
                strBuilder.deleteCharAt(strBuilder.length() - 1);
                visited[j] = false;
            }
        }
    }


    public List<String> fullSort(int num) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation().permutation("abc")));
        System.out.println(Arrays.toString(new Permutation().permutation("aab")));
    }
}
