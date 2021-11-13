import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindWords {
    public String[] findWords(String[] words) {
        List<String> list = Arrays.asList("qwertyuiop","asdfghjkl","zxcvbnm");
        List<String> ans = new ArrayList<>();
        for (String word : words){
            String hang = findHang(list,word.charAt(0));
            if(allIn(hang,word)){
                ans.add(word);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    private boolean allIn(String hang, String word) {
        for (int i = 1; i < word.length(); i++) {
            if(hang.indexOf(Character.toLowerCase(word.charAt(i)))<0){
                return false;
            }
        }
        return true;
    }

    private String findHang(List<String> list, char ch) {
        for(String hang:list){
            if(hang.indexOf(Character.toLowerCase(ch))>=0){
                return hang;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindWords().findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
        System.out.println(Arrays.toString(new FindWords().findWords(new String[]{"omk"})));
        System.out.println(Arrays.toString(new FindWords().findWords(new String[]{"adsdf","sfd"})));
    }
}
