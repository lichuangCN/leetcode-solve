package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/01
 * 112.路径总和
 */
public class $112_hasPathSum {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    boolean exist = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        travel(root, 0, targetSum);
        return exist;
    }

    private void travel(TreeNode node, int curr, int target) {
        if (node == null || exist) {
            return;
        }
        curr = curr + node.val;
        if (node.left == null && node.right == null && curr == target) {
            exist = true;
            return;
        }
        travel(node.left, curr, target);
        travel(node.right, curr, target);
    }
}
