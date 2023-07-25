package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/07/25
 * 101.对称二叉树
 */
public class $101_isSymmetric {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return travel(root.left, root.right);
    }

    private boolean travel(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return travel(left.left, right.right) && travel(left.right, right.left);
    }


    public boolean isSymmetric_2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }
        // ArrayDeque 不允许添加null元素 故此处在添加节点到队列中需要多处判断
        // LinkedList 允许添加null元素 添加节点到元素中时不需要判断空值
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            // 成对出现
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1.val != n2.val) {
                return false;
            }
            // 任意一对非空
            if ((n1.left == null && n2.right != null) || (n1.left != null && n2.right == null)) {
                return false;
            }
            if (n1.left != null && n2.right != null) {
                queue.add(n1.left);
                queue.add(n2.right);
            }
            if ((n1.right == null && n2.left != null) || (n1.right != null && n2.left == null)) {
                return false;
            }
            if (n1.right != null && n2.left != null) {
                queue.add(n1.right);
                queue.add(n2.left);
            }
        }
        return true;
    }
}
