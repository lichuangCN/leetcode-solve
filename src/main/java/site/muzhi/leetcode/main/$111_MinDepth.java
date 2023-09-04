package site.muzhi.leetcode.main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichuang
 * @date 2020/08/21
 * @description 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 深度是指从根节点到叶子节点路径上的节点数，闭区间 [根节点，叶子节点]
 */
public class $111_MinDepth {

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
     * 层序遍历（广度搜索）
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 1;
        while (!queue.isEmpty()) {
            // 当前层节点数
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                // 叶子节点
                TreeNode left = node.left;
                TreeNode right = node.right;
                // 如果当前节点左右均为空，表示当前节点已经是叶子节点，无需再向下层继续遍历
                // 已经到了第一个叶子节点
                if (left == null && right == null) {
                    return minDepth;
                }
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }

    /**
     * 深度优先遍历(其实也算是求树深)
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 默认最大值，不过不会用到
        int minDepth = Integer.MAX_VALUE;
        // 确认当前树最小深度
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth2(root.left));
        }

        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepth2(root.right));
        }
        return minDepth + 1;
    }

}
