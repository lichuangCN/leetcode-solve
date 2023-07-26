package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/07/26
 * 129.根节点到叶节点数字之和
 */
public class $129_sumNumbers {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                // 叶子节点
                if (node.left == null && node.right == null) {
                    ans += node.val;
                }
                if (node.left != null) {
                    node.left.val = node.val * 10 + node.left.val;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 10 + node.right.val;
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }
}
