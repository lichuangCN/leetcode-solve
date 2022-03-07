package site.muzhi.leetcode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/12/09
 * @description 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class $32_3_LevelOrder {
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

    /**
     * 结果导向（…+…-…+…）
     */
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> level = new LinkedList<>();
        level.addLast(root);
        while (!level.isEmpty()) {
            List<Integer> buffer = new ArrayList<>();
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = level.pollFirst();
                buffer.add(node.val);
                if (node.left != null) {
                    level.addLast(node.left);
                }
                if (node.right != null) {
                    level.addLast(node.right);
                }
            }
            ans.add(buffer);
        }

        // 反转
        for (int i = 0; i < ans.size(); i++) {
            if ((i & 1) == 1) {
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }
}
