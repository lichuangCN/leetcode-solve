package site.muzhi.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lichuang
 * @date 2020/08/25
 * @description 二叉树的层次遍历 II
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 */
public class $107_LevelOrderBottom {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            // 当前层节点值列表
            ArrayList<Integer> levelNode = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                levelNode.add(node.val);
                TreeNode left = node.left;
                if (left != null) {
                    queue.add(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    queue.add(right);
                }
            }
            res.addFirst(levelNode);
        }
        return res;
    }
}
