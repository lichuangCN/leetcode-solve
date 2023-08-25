package site.muzhi.leetcode.group.offerII;

import java.util.List;

/**
 * @author lichuang
 * @date 2023/05/26
 * 63.替换单词
 */
public class $63_replaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Dictionary dict = new Dictionary(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder newSentence = new StringBuilder();
        for (String word : words) {
            newSentence.append(dict.getRootDict(word)).append(" ");
        }
        String s = newSentence.toString();
        return s.substring(0, s.length() - 1);
    }

    class Dictionary {

        Node root;

        class Node {
            Node[] children = new Node[26];
            boolean end;
        }

        public Dictionary(List<String> dicts) {
            this.root = new Node();
            for (String dict : dicts) {
                add(dict);
            }
        }

        public void add(String dict) {
            if (dict == null || "".equals(dict)) {
                return;
            }
            Node node = root;
            char[] chars = dict.toCharArray();
            for (char c : chars) {
                int idx = getIdx(c);
                if (node.children[idx] == null) {
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
            }
            node.end = true;
        }

        private String getRootDict(String word) {
            if (word == null || "".equals(word)) {
                return word;
            }
            Node node = root;
            char[] chars = word.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char c : chars) {
                int idx = getIdx(c);
                if (node.children[idx] == null) {
                    return word;
                }
                builder.append((char) (idx + 'a'));
                // 最短字典节点
                if (node.children[idx].end) {
                    return builder.toString();
                }
                node = node.children[idx];
            }
            return word;
        }

        private int getIdx(char c) {
            return c - 'a';
        }

    }
}
