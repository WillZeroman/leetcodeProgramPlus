package tree;

import java.util.HashMap;

public class Trie {

    private TrieNode root;
    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode('/');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        //check null
        if(word.length()==0){
            return;
        }
        TrieNode cursor = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            HashMap<Character,TrieNode> children = cursor.children;
            if(!children.containsKey(ch)){
                TrieNode node = new TrieNode(ch);
                children.put(ch,node);
            }
            cursor = children.get(ch);
        }
        cursor.word = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node!=null && node.word;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) !=null;
    }


    private TrieNode searchNode(String text){
        TrieNode cursor = root;
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            HashMap<Character,TrieNode> children = cursor.children;
            if(children.containsKey(ch)){
                cursor = children.get(ch);
            }else {
                return null;
            }
        }
        return cursor;
    }

    class TrieNode {
        char ch;
        HashMap<Character,TrieNode> children = new HashMap<>();
        boolean word;
        TrieNode(char ch){
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        /**
         * Your Trie object will be instantiated and called as such:
         * Trie obj = new Trie();
         * obj.insert(word);
         * boolean param_2 = obj.search(word);
         * boolean param_3 = obj.startsWith(prefix);
         */
        String word = "hello";
        String prefix = "he";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(obj.startsWith("hello"));
        System.out.println(obj.startsWith("asdf"));

    }
}
