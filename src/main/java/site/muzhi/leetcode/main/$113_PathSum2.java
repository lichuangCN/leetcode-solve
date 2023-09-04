package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: LiChuang
 * @date: 2020/02/27
 * @description: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 当前思路：通过维护一个栈保存已经遍历过的节点
 */
public class $113_PathSum2 {
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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 保存结果
        List<List<Integer>> result = new ArrayList<>();
        // 保存遍历的路径
        LinkedList<Integer> stack = new LinkedList<>();
        search(root, stack, result, sum);
        return result;
    }

    /**
     * @param node   当前节点
     * @param stack  保存当前的遍历路径
     * @param result 保存满足条件的路径列表
     * @param sum    当前节点下的路径和
     */
    public void search(TreeNode node, LinkedList<Integer> stack, List<List<Integer>> result, int sum) {
        // 当当前节点为空
        if (node == null) {
            return;
        }
        // 当前节点为叶子结点
        if (node.left == null && node.right == null) {
            // 满足目标和条件
            if (sum == node.val) {
                // 将当前节点加入栈
                stack.addLast(node.val);
                List<Integer> list = new ArrayList<>(stack);
                // 将满足条件的结果保存1
                result.add(list);
                // 将当前节点弹出
                stack.removeLast();
                return;
            } else {
                // 不满足目标和条件
                return;
            }
        }
        // 以下是当前节点不是叶子结点的情况
        // 将当前节点入栈
        stack.addLast(node.val);
        // 递归左叶子节点
        search(node.left, stack, result, sum - node.val);
        // 递归右叶子节点
        search(node.right, stack, result, sum - node.val);
        // 当前节点的左右叶子节点遍历完毕，弹出当前节点
        stack.removeLast();
    }
}
