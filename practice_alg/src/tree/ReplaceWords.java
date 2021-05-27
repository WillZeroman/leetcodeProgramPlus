package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReplaceWords {

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode('/');
        }

        public void insert(String word) {
            //check null
            if (word.length() == 0) {
                return;
            }
            TrieNode cursor = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                HashMap<Character, TrieNode> children = cursor.children;
                if (!children.containsKey(ch)) {
                    TrieNode node = new TrieNode(ch);
                    children.put(ch, node);
                }
                cursor = children.get(ch);
            }
            cursor.word = true;
            cursor.prefix = word;
        }

        public String findPrefix(String word) {
            TrieNode cursor = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                HashMap<Character, TrieNode> children = cursor.children;
                if (children.containsKey(ch)) {
                    cursor = children.get(ch);
                    if(cursor.word){
                        break;
                    }
                } else {
                    break;
                }
            }
            return cursor.prefix;
        }
    }

    class TrieNode {
        char ch;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean word;
        String prefix;

        TrieNode(char ch) {
            this.ch = ch;
        }
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        // build trie
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            String prefix = trie.findPrefix(word);
            if (prefix != null) {
                res.append(prefix);
            } else {
                res.append(word);
            }
            res.append(" ");
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceWords().replaceWords(Arrays.asList("cat","bat","rat"),"the cattle was rattled by the battery"));
        System.out.println(new ReplaceWords().replaceWords(Arrays.asList("a", "aa", "aaa", "aaaa"),"a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }
}
