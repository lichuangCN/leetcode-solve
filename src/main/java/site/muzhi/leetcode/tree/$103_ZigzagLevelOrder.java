package site.muzhi.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/08/27
 * @description 二叉树的锯齿形层次遍历
 */
public class $103_ZigzagLevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new LinkedList<>();

        // 当前层数，
        // 奇数时从左向右；偶数时从右向左
        int level = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>(size);

            if ((level & 1) == 0) {
                // 偶数
                for (int i = 0; i < size; i++) {
                    // 从队尾取节点
                    TreeNode node = queue.pollLast();
                    levelList.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            } else {
                // 奇数
                for (int i = 0; i < size; i++) {
                    // 从队首取元素
                    TreeNode node = queue.pollFirst();
                    levelList.add(node.val);
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                }
            }
            res.add(levelList);
            level++;
        }
        return res;
    }
}
