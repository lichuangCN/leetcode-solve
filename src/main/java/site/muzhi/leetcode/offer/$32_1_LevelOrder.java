package site.muzhi.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2022/03/07
 * @description 面试题32 - I. 从上到下打印二叉树
 * <p>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class $32_1_LevelOrder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> buffer = new ArrayList<>();
        LinkedList<TreeNode> level = new LinkedList<>();
        level.addLast(root);
        while (!level.isEmpty()) {
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
        }
        int[] ans = new int[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            ans[i] = buffer.get(i);
        }
        return ans;
    }
}
