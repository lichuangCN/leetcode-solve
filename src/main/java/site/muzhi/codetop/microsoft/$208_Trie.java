package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/10
 * @description 208.实现 Trie (前缀树)
 */
public class $208_Trie {
    class Trie {

        class Node {
            // idx != null 表示存在
            Node[] children = new Node[26];
            // 当前结点满足一个完整单词
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
            char[] array = word.toCharArray();
            Node node = root;
            for (char c : array) {
                int idx = c - 'a';
                //
                if (node.children[idx] == null) {
                    // 初始化节点
                    node.children[idx] = new Node();
                }
                // 下一层
                node = node.children[idx];
            }
            // 到此是一个完整的单词
            node.setEnd(true);
        }

        public boolean search(String word) {
            if (word == null || "".equals(word)) {
                return false;
            }
            Node node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
            return node.end;
        }

        public boolean startsWith(String prefix) {
            if (prefix == null || "".equals(prefix)) {
                return false;
            }
            Node node = root;
            for (char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
            return true;
        }
    }
}
