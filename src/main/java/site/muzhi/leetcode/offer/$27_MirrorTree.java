package site.muzhi.leetcode.offer;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2020/09/26
 * @description 剑指 Offer 27. 二叉树的镜像
 * <p>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class $27_MirrorTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归1-先序遍历
     */
    public TreeNode mirrorTree_1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        mirrorTree_1(root.left);
        mirrorTree_1(root.right);
        return root;
    }

    /**
     * 递归2-中序遍历
     */
    public TreeNode mirrorTree_2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = mirrorTree_2(root.left);
        root.left = mirrorTree_2(right);
        return root;
    }

    /**
     * 递归3-后序遍历
     */
    public TreeNode mirrorTree_3(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = mirrorTree_3(root.left);
        TreeNode left = mirrorTree_3(root.right);
        root.right = right;
        root.left = left;
        return root;
    }

    /**
     * 层序遍历
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
        }
        return root;
    }
}
