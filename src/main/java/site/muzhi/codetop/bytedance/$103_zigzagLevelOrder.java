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
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0; // 根节点层码
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelVal = new ArrayList<>(size);
            ans.add(levelVal);

            // 保证队列中的元素能够按照树中每一层都从左到右的顺序插入
            for (int i = 0; i < size; i++) {
                if ((level & 1) == 0) {
                    // 偶数层, 从左到右遍历
                    TreeNode node = queue.pollFirst();
                    levelVal.add(node.val);
                    // 下一层节点，从队尾插入
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                } else {
                    // 奇数层, 从右到左遍历
                    TreeNode node = queue.pollLast();
                    levelVal.add(node.val);
                    // 下一层节点，从队首插入
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            level++;
        }
        return ans;
    }
}
