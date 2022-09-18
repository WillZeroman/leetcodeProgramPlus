import java.util.Arrays;

public class PrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(words[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new PrefixOfWord().isPrefixOfWord("i love eating burger","burg"));
        System.out.println(new PrefixOfWord().isPrefixOfWord("this problem is an easy problem","pro"));
        System.out.println(new PrefixOfWord().isPrefixOfWord("i am tired","you"));
    }
}
