import java.util.List;

public class Permutation {

    int count;
    String[] ans;

    public String[] permutation(String s) {
        int size = s.length();
        count = sum(size);
        ans = new String[count];
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[size];
        dfs(s,sb,size,0,visited);

        return ans;
    }

    private void dfs(String s, StringBuilder sb, int size, int i, boolean[] visited) {
        if(sb.length() == size){
            String sort = sb.toString();
            StringBuilder tempAns = new StringBuilder();
            for (int j = 0; j < sort.length(); j++) {
                char ch = sort.charAt(j);
                tempAns.append(s.charAt(ch-'0'));
            }
            ans[count] = tempAns.toString();
            count ++;
            return;
        }
        for (int j = 0; j <size; j++) {
            char ch = s.charAt(j);
            sb.append(ch);
            visited[j] = true;

            visited[j] = false;
        }
    }

    private int sum(int num){
        int sum = 1;
        for(int i=0;i<=num;i++){
            sum *=i;
        }
        return sum;
    }


    public List<String> fullSort(int num){
        return null;
    }
}
