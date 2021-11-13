package com;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private TreeNode root;

    public WordDictionary() {
        root = new TreeNode(' ');
    }

    public void addWord(String word) {
        TreeNode cursor = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TreeNode node = cursor.children.getOrDefault(ch,new TreeNode(ch));
            cursor.children.put(ch,node);
            cursor = node;
        }
        cursor.end = true;
    }

    public boolean search(String word) {
        TreeNode node = search(root,word,0);
        return node!=null && node.end;
    }

    private TreeNode search(TreeNode node,String word,int index){
        if(index == word.length()){
            return node;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (TreeNode value : node.children.values()) {
                TreeNode res = search(value,word,index +1);
                if (res!=null) {
                    return res;
                }
            }
            return null;
        } else {
            if (node.children.containsKey(ch)) {
                TreeNode res = search(node.children.get(ch),word,index+1);
                return res;
            } else {
                return null;
            }
        }
    }


    class TreeNode {
        char ch;
        Map<Character,TreeNode> children = new HashMap<>();
        boolean end;
        TreeNode(char ch){
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dada");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
        System.out.println(wordDictionary.search(".m.")); // return True
        System.out.println(wordDictionary.search(".a.")); // return True
    }
}
