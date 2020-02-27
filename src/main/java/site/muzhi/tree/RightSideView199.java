package site.muzhi.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: LiChuang
 * @date: 2020/02/27
 * @description: 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightSideView199 {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历当前层的前 size-1个元素，添加其左右子节点
            for (int i = 0; i < size - 1; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 当前层的最后一个元素
            TreeNode lastNode = queue.poll();
            result.add(lastNode.val);
            // 添加最后一个节点的左右子节点
            if (lastNode.left != null) {
                queue.add(lastNode.left);
            }
            if (lastNode.right != null) {
                queue.add(lastNode.right);
            }
        }
        return result;
    }

}
