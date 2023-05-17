package site.muzhi.leetcode.offerII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/05/17
 * 56.二叉搜索树中两个节点之和
 */
public class $56_findTarget {

    public boolean findTarget(TreeNode root, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        travel(root, queue);
        while (queue.size() > 1) {
            Integer left = queue.peekFirst();
            Integer right = queue.peekLast();
            if (left + right == k) {
                return true;
            }
            if (left + right < k) {
                queue.pollFirst();
            } else {
                queue.pollLast();
            }
        }
        return false;
    }

    public void travel(TreeNode node, Deque<Integer> queue) {
        if (node == null) {
            return;
        }
        travel(node.left, queue);
        queue.addLast(node.val);
        travel(node.right, queue);
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
