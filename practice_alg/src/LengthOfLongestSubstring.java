import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                int tempLen = i - start;
                max = Math.max(tempLen,max);
                start = Math.max(start,map.get(ch) +1);
            }
            map.put(ch,i);
        }
        max = Math.max(s.length() - start,max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(" "));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abba"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
    }
}
