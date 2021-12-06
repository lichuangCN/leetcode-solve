package site.muzhi.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/12/09
 * @description 层序打印二叉树
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class $32_LevelOrder_3 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if ((level & 1) == 1) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
            resList.add(levelList);
        }
        return resList;
    }
}
