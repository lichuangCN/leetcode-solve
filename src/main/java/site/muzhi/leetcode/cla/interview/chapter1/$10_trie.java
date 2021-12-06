package site.muzhi.leetcode.cla.interview.chapter1;

/**
 * @author lichuang
 * @date 2021/04/13
 * @description 实现 Trie (前缀树)
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xaeate/
 */
public class $10_trie {

    class Trie {
        class Node {
            boolean end;
            Node[] children = new Node[26];
            public void setEnd(boolean end) {
                this.end = end;
            }
        }

        Node root = null;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || "".equals(word)) {
                return;
            }
            char[] array = word.toCharArray();
            Node node = this.root;
            for (int i = 0; i < array.length; i++) {
                int idx = array[i] - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
            }
            node.setEnd(true);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || "".equals(word)) {
                return false;
            }
            char[] array = word.toCharArray();
            Node node = this.root;
            for (int i = 0; i < array.length; i++) {
                int idx = array[i] - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
            return node.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || "".equals(prefix)) {
                return false;
            }
            char[] array = prefix.toCharArray();
            Node node = this.root;
            for (int i = 0; i < array.length; i++) {
                int idx = array[i] - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
            return true;
        }
    }
}
