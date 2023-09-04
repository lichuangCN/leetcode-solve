package site.muzhi.leetcode.group.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/09/04
 * 114.二叉树展开为链表
 */
public class $114_flatten {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> queue = new ArrayList<>();
        travel(root, queue);

        // 重新构建
        for (int i = 1; i < queue.size(); i++) {
            TreeNode prev = queue.get(i - 1), curr = queue.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void travel(TreeNode node, List<TreeNode> queue) {
        if (node == null) {
            return;
        }
        queue.add(node);
        travel(node.left, queue);
        travel(node.right, queue);
    }
}
