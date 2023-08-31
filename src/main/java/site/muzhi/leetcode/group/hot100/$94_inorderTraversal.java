package site.muzhi.leetcode.group.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/08/31
 * 94.二叉树的中序遍历
 */
public class $94_inorderTraversal {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        travel(root, ans);
        return ans;
    }

    private void travel(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        travel(root.left, ans);
        ans.add(root.val);
        travel(root.right, ans);
    }
}
