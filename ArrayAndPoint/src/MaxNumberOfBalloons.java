import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<"balloon".length();i++){
            map.put("balloon".charAt(i),0);
        }
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
        }
        map.put('l',map.get('l')/2);
        map.put('o',map.get('o')/2);
        int ans = Integer.MAX_VALUE;
        for(int count : map.values()){
            ans = Math.min(count,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxNumberOfBalloons().maxNumberOfBalloons("nlaebolko"));
        System.out.println(new MaxNumberOfBalloons().maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(new MaxNumberOfBalloons().maxNumberOfBalloons("leetcode"));
        System.out.println(new MaxNumberOfBalloons().maxNumberOfBalloons("l"));
    }
}
