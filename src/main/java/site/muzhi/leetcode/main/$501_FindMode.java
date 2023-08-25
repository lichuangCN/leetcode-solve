package site.muzhi.leetcode.tree;

import java.util.ArrayList;

/**
 * @author lichuang
 * @date 2020/09/02
 * @description 二叉搜索树中的众数
 */
public class $501_FindMode {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 当前值出现的次数
     */
    int currCount = 0;
    /**
     * 最大出现次数
     */
    int maxCount = 0;
    int preVal = 0;
    ArrayList<Integer> res = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        int val = node.val;

        // 当前值与上一个值的关系
        if (preVal == val) {
            currCount ++;
        } else {
            currCount = 1;
            preVal = val;
        }

        // 比较当前值出现的次数
        if (currCount == maxCount) {
            res.add(val);
        } else if (currCount> maxCount) {
            res.clear();
            res.add(val);
            maxCount = currCount;
        }

        inOrderTraversal(node.right);
    }

}
