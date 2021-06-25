package site.muzhi.tree;

import java.util.*;

/**
 * @author lichuang
 * @date 2021/06/24
 * @description
 */
public class $653_findTarget {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        travel(root, list);
        Set<Integer> set = new HashSet<>();
        for (Integer val : list) {
            if (set.contains(k - val)) {
                return true;
            }
            set.add(val);
        }
        return false;
    }

    /**
     * 中序遍历
     *
     * @param node
     * @param list
     */
    private void travel(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        travel(node.left, list);
        list.add(node.val);
        travel(node.right, list);
    }
}
