package site.muzhi.leetcode.group.offerII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/05/12
 * 53.二叉搜索树中的中继后续
 */
public class $53_inorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        travel(root, queue);

        // 寻找目标节点
        while (true) {
            if (queue.isEmpty() || p.val == queue.pollFirst().val) {
                break;
            }
        }
        return queue.isEmpty() ? null : queue.pollFirst();
    }

    private void travel(TreeNode node, Deque<TreeNode> queue) {
        if (node == null) {
            return;
        }
        // 中序遍历
        travel(node.left, queue);
        queue.addLast(node);
        travel(node.right, queue);
    }

    class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;
    }
}
