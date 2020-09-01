package site.muzhi.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/09/01
 * @description 二叉树的所有路径
 * <p>
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class $257_BinaryTreePaths {

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

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<String> res = new LinkedList<>();
        travesal("", root, res);
        return res;
    }

    public void travesal(String str, TreeNode node, List<String> res) {
        if (node == null) {
            return;
        }
        str += String.valueOf(node.val);
        if (node.left == null && node.right == null) {
            res.add(str);
            return;
        }
        str += "->";
        travesal(str, node.left, res);
        travesal(str, node.right, res);
    }
}
