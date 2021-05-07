package site.muzhi.cla.interview.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/05/07
 * @description 二叉树的序列化与反序列化
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xasfi3/
 */
public class $3_codec {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder preBuilder = new StringBuilder();
            doSerialize(root, preBuilder);
            String s = preBuilder.toString();
            return s.substring(0, s.length() - 1);
        }

        // 前序遍历
        private void doSerialize(TreeNode node, StringBuilder builder) {
            if (node == null) {
                builder.append("#").append(",");
                return;
            }
            builder.append(node.val).append(",");
            doSerialize(node.left, builder);
            doSerialize(node.right, builder);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || "".equals(data)) {
                return null;
            }
            String[] split = data.split(",");
            List<String> list = new ArrayList<>(Arrays.asList(split));
            TreeNode node = doDeserialize(list);
            return node;
        }

        private TreeNode doDeserialize(List<String> list) {
            if (list.get(0).equals("#")) {
                list.remove(0);
                return null;
            }
            Integer val = Integer.valueOf(list.get(0));
            TreeNode node = new TreeNode(val);
            list.remove(0);
            node.left = doDeserialize(list);
            node.right = doDeserialize(list);
            return node;
        }
    }
}
