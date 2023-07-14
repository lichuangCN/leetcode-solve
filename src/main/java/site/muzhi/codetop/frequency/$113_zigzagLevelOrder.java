package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/13
 * 113.二叉树的锯齿形层序遍历
 */
public class $113_zigzagLevelOrder {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curr = new ArrayList<>(size);
            if (level % 2 == 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.removeFirst();
                    curr.add(node.val);
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.removeLast();
                    curr.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            level++;
            ans.add(curr);
        }
        return ans;
    }
}
