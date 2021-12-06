package site.muzhi.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/09/26
 * @description
 */
public class $113_PathSum2_2 {

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

    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> tem = new LinkedList<>();

    private int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        search(root, 0);
        return res;
    }

    private void search(TreeNode node, int temSum) {
        if (node == null) {
            return;
        }
        int currSum = temSum + node.val;
        tem.addLast(node.val);
        if (node.left == null && node.right == null && currSum == sum) {
            List<Integer> r = new ArrayList<>(tem.size());
            for (Integer i : tem) {
                r.add(i);
            }
            res.add(r);
        }
        // 递归下一层
        search(node.left, currSum);
        search(node.right, currSum);
        tem.removeLast();
    }
}
