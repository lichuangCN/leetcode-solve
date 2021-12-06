package site.muzhi.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/08/20
 * @description 不同的二叉搜索树 II
 * <p>
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树
 */
public class $95_GenerateTrees {
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

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>(0);
        }
        return generateTree(1, n);
    }

    public List<TreeNode> generateTree(int start, int end) {
        if (start > end) {
            return new ArrayList<>(0);
        }
        LinkedList<TreeNode> treeList = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            // 左侧树列表
            List<TreeNode> leftTrees = generateTree(start, i - 1);
            // 右侧树列表
            List<TreeNode> rightTrees = generateTree(i + 1, end);

            // 两侧树均为空
            if (leftTrees.isEmpty() && rightTrees.isEmpty()) {
                // 当前树根节点
                TreeNode node = new TreeNode(i);
                treeList.add(node);
            }
            // 左侧为空,右侧非空
            if (leftTrees.isEmpty() && !rightTrees.isEmpty()) {
                for (TreeNode rightTree : rightTrees) {
                    // 当前树根节点
                    TreeNode node = new TreeNode(i);
                    node.right = rightTree;
                    treeList.add(node);
                }
            }
            // 左侧非空,右侧为空
            if (!leftTrees.isEmpty() && rightTrees.isEmpty()) {
                for (TreeNode leftTree : leftTrees) {
                    // 当前树根节点
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    treeList.add(node);
                }
            }
            // 左右侧树均非空
            if (!leftTrees.isEmpty() && !rightTrees.isEmpty()) {
                // 拼接出当前节点所有可能的树
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        // 当前树根节点
                        TreeNode node = new TreeNode(i);
                        node.left = leftTree;
                        node.right = rightTree;
                        treeList.add(node);
                    }
                }
            }
        }
        return treeList;
    }

}
