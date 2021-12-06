package site.muzhi.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/08/19
 * @description 给定一个二叉树，返回它的中序遍历
 */
public class $94_InOrderTraversal {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        LinkedList<Integer> res = new LinkedList<>();
        traversal(res, root);
        return res;
    }

    public void traversal(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        // 遍历左侧子树
        traversal(res, root.left);
        // 读取中序节点
        res.add(root.val);
        // 遍历右侧子树
        traversal(res, root.right);
    }
}
