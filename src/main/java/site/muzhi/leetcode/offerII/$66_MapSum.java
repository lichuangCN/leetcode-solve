package site.muzhi.leetcode.offerII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/06/06
 * 66.单词之和
 */
public class $66_MapSum {

    class MapSum {
        TrieNode root;

        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            if (key == null || "".equals(key)) {
                return;
            }
            TrieNode curr = root;
            for (int i = 0; i < key.length(); i++) {
                curr = curr.get(key.charAt(i));
            }
            curr.length = val;
        }

        public int sum(String prefix) {
            if (prefix == null || "".equals(prefix)) {
                return 0;
            }
            TrieNode curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                // 没有该前缀的单词
                TrieNode child = curr.children[prefix.charAt(i) - 'a'];
                if (child == null) {
                    return 0;
                }
                curr = child;
            }
            // curr 前缀的最后一个字母
            return getChildrenSum(curr);
        }

        /**
         * 层序遍历
         */
        private int getChildrenSum(TrieNode node) {
            if (node == null) {
                return 0;
            }
            int sum = 0;
            Deque<TrieNode> queue = new ArrayDeque<>();
            queue.offerLast(node);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TrieNode n = queue.pollFirst();
                    // 当前结点是记录val结点
                    if (n.length != 0) {
                        sum += n.length;
                    }
                    // 子节点
                    for (TrieNode child : n.children) {
                        if (child != null) {
                            queue.add(child);
                        }
                    }
                }
            }
            return sum;
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int length = 0;

            public TrieNode get(char c) {
                int idx = c - 'a';
                if (children[idx] == null) {
                    children[idx] = new TrieNode();
                }
                return children[idx];
            }
        }
    }
}
