package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/27
 * 113.路径总和 II
 */
public class $113_pathSum {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        travel(ans, new ArrayDeque<>(), root, 0, targetSum);
        return ans;
    }

    private void travel(List<List<Integer>> ans, Deque<Integer> curr, TreeNode node, int sum, int target) {
        if (node == null) {
            return;
        }
        curr.add(node.val);
        sum = sum + node.val;
        if (node.left == null && node.right == null && sum == target) {
            ans.add(new ArrayList<>(curr));
            curr.removeLast();
            return;
        }
        travel(ans, curr, node.left, sum, target);
        travel(ans, curr, node.right, sum, target);
        curr.removeLast();
    }
}
