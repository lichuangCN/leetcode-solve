package site.muzhi.codetop.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2022/11/27
 * @description 94.中序遍历
 */
public class $94_inorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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
