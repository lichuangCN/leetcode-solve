package site.muzhi.leetcode.group.hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/09/27
 * 297.二叉树的序列化和反序列化
 */
public class $297_Codec {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Codec {

        public String serialize(TreeNode root) {
            return doSerialize(root, new StringBuilder()).toString();
        }

        public TreeNode deserialize(String data) {
            Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
            return doDeserialize(queue);
        }

        public StringBuilder doSerialize(TreeNode root, StringBuilder builder) {
            if (root == null) {
                builder.append("None,");
            } else {
                builder.append(root.val).append(",");
                doSerialize(root.left, builder);
                doSerialize(root.right, builder);
            }
            return builder;
        }

        public TreeNode doDeserialize(Deque<String> queue) {
            String val = queue.pollFirst();
            if (val.equals("None")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = doDeserialize(queue);
            node.right = doDeserialize(queue);
            return node;
        }
    }
}
