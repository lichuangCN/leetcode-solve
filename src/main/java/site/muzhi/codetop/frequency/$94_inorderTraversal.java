package site.muzhi.codetop.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/17
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

    private void travel(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        travel(node.left, ans);
        ans.add(node.val);
        travel(node.right, ans);
    }
}
