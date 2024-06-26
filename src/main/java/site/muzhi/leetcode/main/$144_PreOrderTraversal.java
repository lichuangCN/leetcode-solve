package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/08/30
 * @description 二叉树的前序遍历
 */
public class $144_PreOrderTraversal {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<Integer> res = new LinkedList<>();

        traversal(res, root);
        return res;
    }

    public void traversal(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        // 前序
        res.add(node.val);
        traversal(res, node.left);
        traversal(res, node.right);
    }
}
