package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/13
 * 208.实现Trie（前缀树）
 */
public class $208_Trie {

    class Trie {

        class Node {
            boolean end;
            Node[] children = new Node[26];
        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            Node n = root;
            for (char c : chars) {
                int idx = getIdx(c);
                if (n.children[idx] == null) {
                    n.children[idx] = new Node();
                }
                n = n.children[idx];
            }
            // 标识当前是某个单词的结尾
            n.end = true;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Node n = root;
            for (char c : chars) {
                int idx = getIdx(c);
                if (n.children[idx] == null) {
                    return false;
                }
                n = n.children[idx];
            }
            // 寻找完毕，判断word是否是当前字典树中的单词
            return n.end;
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Node n = root;
            for (char c : chars) {
                int idx = getIdx(c);
                if (n.children[idx] == null) {
                    return false;
                }
                n = n.children[idx];
            }
            return true;
        }

        private int getIdx(char c) {
            return c - 'a';
        }
    }

}
