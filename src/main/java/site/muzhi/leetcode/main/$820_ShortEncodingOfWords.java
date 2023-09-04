package site.muzhi.leetcode.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: lichuang
 * @date: 2020/03/28
 * @description: 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，
 * 我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，
 * 直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 */

public class $820_ShortEncodingOfWords {

    /**
     * 使用集合过滤法
     *
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                // 在集合中移除可能是当前单词后缀的元素
                wordSet.remove(word.substring(i));
            }
        }

        int result = 0;
        for (String word : wordSet) {
            result += word.length() + 1;
        }
        return result;
    }

    /**
     * 使用字典树
     *
     * @param words
     * @return
     */
    public int minimumLengthEncoding2(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        int len = 0;
        Trie trie = new Trie();
        // 将单词按照长度由大到小排列
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String word : words) {
            len += trie.insert(word);
        }
        return len;
    }

    class Trie {

        TreeNode root;

        public Trie() {
            this.root = new TreeNode();
        }

        // 插入新的单词
        public int insert(String word) {
            // 判断当前单词是否能在字典树中寻找到
            boolean newWord = false;
            TreeNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    // 是新单词
                    newWord = true;
                    cur.children[c - 'a'] = new TreeNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            // 如果是新单词，返回单词的长度+1
            return (newWord == true) ? word.length() + 1 : 0;
        }
    }

    class TreeNode {
        char val;
        TreeNode[] children = new TreeNode[26];

        public TreeNode() {
        }

        public TreeNode(char val) {
            this.val = val;
        }
    }
}
