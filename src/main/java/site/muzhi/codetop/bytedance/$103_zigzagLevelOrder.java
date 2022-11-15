package site.muzhi.codetop.bytedance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2022/11/15
 * @description 103. 二叉树的锯齿形层序遍历
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 */
public class $103_zigzagLevelOrder {

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
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int level = 0;
        while (!deque.isEmpty()) {
            List<Integer> levelVal = new ArrayList<>(deque.size());
            int levelSize = deque.size();
            if ((level & 1) == 0) {
                // 偶数层: 从左向右 从队首取节点
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = deque.pollFirst();
                    levelVal.add(node.val);
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                }
            } else {
                // 奇数层：从右向左 从队尾取节点
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = deque.pollLast();
                    levelVal.add(node.val);
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                }
            }
            level++;
            ans.add(levelVal);
        }
        return ans;
    }
}
