package tree;

import java.util.*;

public class FindWord {

    class Trie {

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
            cursor.isWord = true;
            cursor.word = word;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchNode(word);
            return node != null && node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchNode(prefix) != null;
        }

        public TrieNode searchRootNode(char ch) {
            HashMap<Character, TrieNode> children = root.children;
            return children.get(ch);
        }

        private TrieNode searchNode(String text) {
            TrieNode cursor = root;
            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                HashMap<Character, TrieNode> children = cursor.children;
                if (children.containsKey(ch)) {
                    cursor = children.get(ch);
                } else {
                    return null;
                }
            }
            return cursor;
        }
    }

    class TrieNode {
        char ch;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
        String word;

        TrieNode(char ch) {
            this.ch = ch;
        }
    }

    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie tree = new Trie();
        for (String word : words) {
            tree.insert(word);
        }
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                TrieNode node = tree.searchRootNode(board[i][j]);
                if (node != null) {
                    boolean[][] visited = new boolean[board.length][board[i].length];
                    visited[i][j] = true;
                    search(board, i, j, visited, node, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void search(char[][] board, int i, int j, boolean[][] visited, TrieNode node, Set<String> result) {
        if (node.isWord) {
            result.add(node.word);
        }
        for (int m = 0; m < dir.length; m++) {
            int newI = i + dir[m][0];
            int newJ = j + dir[m][1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[i].length && !visited[newI][newJ]) {
                visited[newI][newJ] = true;
                if (node.children.containsKey(board[newI][newJ])) {
                    search(board, newI, newJ, visited, node.children.get(board[newI][newJ]), result);
                }
                visited[newI][newJ] = false;
            }
        }
    }

    public static void main(String[] args) {
        //board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new FindWord().findWords(board, words));
    }
}
