package site.muzhi.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichuang
 * @date 2020/08/21
 * @description 对称二叉树
 * <p>
 * 如果说要对称，那就从左右入手
 */
public class $101_IsSymmetric {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    /**
     * 迭代（层序遍历）
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        // 通过层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null) {
                continue;
            }
            // 这里的时候 n1和n2至少有一个非空, 此时已经不等
            // 如果n1和n2 均非空，判断二者的val是否相同
            if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }
            // 关键 对称加入叶子节点
            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }
}
