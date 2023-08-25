package site.muzhi.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description 872. 叶子相似的树
 * <p>
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class $872_LeafSimilar {
    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        // 遍历树，获取叶子节点
        List<Integer> list1 = new ArrayList<>();
        track(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        track(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 前序遍历，获取叶子节点
     *
     * @param node
     */
    private void track(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        track(node.left, list);
        track(node.right, list);
    }
}
