package site.muzhi.codetop.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/01/17
 * 114
 */
public class $114_flatten {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> queue = new ArrayList<>();
        travel(root, queue);
        for (int i = 1; i < queue.size(); i++) {
            TreeNode prev = queue.get(i - 1), curr = queue.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void travel(TreeNode root, List<TreeNode> queue) {
        if (root == null) {
            return;
        }
        queue.add(root);
        travel(root.left, queue);
        travel(root.right, queue);
    }
}
