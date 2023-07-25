package site.muzhi.codetop.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/25
 * 114.二叉树的前序遍历
 */
public class $114_preorderTraversal {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        travel(ans, root);
        return ans;
    }

    private void travel(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        travel(ans, node.left);
        travel(ans, node.right);
    }
}
