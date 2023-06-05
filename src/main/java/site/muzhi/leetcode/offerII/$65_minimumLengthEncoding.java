package site.muzhi.leetcode.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/06/05
 * 65.最短的单词编码
 * 存储后缀
 */
public class $65_minimumLengthEncoding {

    /**
     * 采用Set集合存储后缀
     */
//    public int minimumLengthEncoding(String[] words) {
//        Set<String> set = new HashSet<>(Arrays.asList(words));
//        // 移除集合中符合规则的短词
//        for (String word : words) {
//            for (int i = 1; i < word.length(); i++) {
//                set.remove(word.substring(i));
//            }
//        }
//
//        int ans = 0;
//        for (String w : set) {
//            ans += w.length() + 1;
//        }
//        return ans;
//    }

    /**
     * 后缀树
     */
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        // <后缀树的尾结点，单词在数组中的索引> ==> 通过node节点找到对应的单词
        Map<TrieNode, Integer> nodeMap = new HashMap<>();
        // 初始化后缀树
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode curr = root;
            for (int j = word.length() - 1; j >= 0; j--) {
                curr = curr.get(word.charAt(j));
            }
            nodeMap.put(curr, i);
        }

        int ans = 0;
        for (Map.Entry<TrieNode, Integer> entry : nodeMap.entrySet()) {
            TrieNode key = entry.getKey();
            Integer idx = entry.getValue();
            // 叶子节点
            if (key.count == 0) {
                ans += words[idx].length() + 1;
            }
        }
        return ans;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        // 统计子节点
        int count;

        public TrieNode get(char c) {
            int idx = c - 'a';
            if (children[idx] == null) {
                children[idx] = new TrieNode();
                // 子节点个数 +1
                count++;
            }
            return children[idx];
        }
    }
}
