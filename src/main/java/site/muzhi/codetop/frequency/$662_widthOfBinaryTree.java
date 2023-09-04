package site.muzhi.codetop.frequency;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/08/09
 * 662.二叉树最大宽度
 */
public class $662_widthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(root, 1));

        int max = 1;
        while (!queue.isEmpty()) {
            // 下一层节点
            Deque<Pair<TreeNode, Integer>> next = new ArrayDeque<>();
            for (Pair<TreeNode, Integer> obj : queue) {
                TreeNode node = obj.getKey();
                Integer no = obj.getValue();
                // 下一层节点编号
                if (node.left != null) {
                    next.add(new Pair<>(node.left, no * 2));
                }
                if (node.right != null) {
                    next.add(new Pair<>(node.right, no * 2 + 1));
                }
            }
            // 计算当前层的最大值
            max = Math.max(max, queue.getLast().getValue() - queue.getFirst().getValue() + 1);
            queue = next;
        }
        return max;
    }
}
