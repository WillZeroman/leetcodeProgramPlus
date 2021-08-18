import java.util.HashMap;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0){
            return false;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<pushed.length;i++){
            map.put(pushed[i],i);
        }
        int[] visited = new int[popped.length];
        for (int i = 0; i <popped.length; i++) {
            visited[i] = map.get(popped[i]);
        }

        return false;
    }
}
