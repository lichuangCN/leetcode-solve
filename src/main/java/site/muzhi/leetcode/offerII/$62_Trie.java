package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/05/25
 * 62.实现前缀树
 */
public class $62_Trie {

    class Trie {

        class Node {
            Node[] children = new Node[26];
            boolean end;

            public void setEnd(boolean end) {
                this.end = end;
            }
        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null || "".equals(word)) {
                return;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            for (char c : chars) {
                int index = getIndex(c);
                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }
                node = node.children[index];
            }
            // 单词结束
            node.setEnd(true);
        }

        public boolean search(String word) {
            if (word == null || "".equals(word)) {
                return false;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            for (char c : chars) {
                int index = getIndex(c);
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.end;
        }

        public boolean startsWith(String prefix) {
            if (prefix == null || "".equals(prefix)) {
                return false;
            }
            char[] chars = prefix.toCharArray();
            Node node = root;
            for (char c : chars) {
                int index = getIndex(c);
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }

        private int getIndex(char c) {
            return c - 'a';
        }
    }
}
