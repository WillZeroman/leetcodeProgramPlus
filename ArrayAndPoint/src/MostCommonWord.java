import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>();
        for (String banWord : banned) {
            banSet.add(banWord);
        }
        //!?',;.
        Set<Character> biaodian = new HashSet<>();
        biaodian.add('!');
        biaodian.add('?');
        biaodian.add('\'');
        biaodian.add(',');
        biaodian.add(';');
        biaodian.add('.');
        biaodian.add(' ');
        HashMap<String, Integer> hashMap = new HashMap<>();
        int start = 0;
        for (int i = 0; i < paragraph.length(); i++) {
            if(biaodian.contains(paragraph.charAt(i))){
                if (i > start) {
                    String word = paragraph.substring(start, i).toLowerCase();
                    int count = hashMap.getOrDefault(word,0);
                    count ++;
                    hashMap.put(word,count);
                }
                start = i + 1;
            }
        }
        if(start<paragraph.length()){
            String word = paragraph.substring(start, paragraph.length()).toLowerCase();
            int count = hashMap.getOrDefault(word,0);
            count ++;
            hashMap.put(word,count);
        }
        System.out.println(hashMap);
        String ans = "";
        int maxCount = 0;
        for (String key : hashMap.keySet()){
            if(!banSet.contains(key)){
                int count = hashMap.get(key);
                if(count>maxCount){
                    maxCount = count;
                    ans = key;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new MostCommonWord()
//                .mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
        System.out.println(new MostCommonWord().mostCommonWord("Bob. hIt, baLl",new String[]{"bob", "hit"}));
    }
}
