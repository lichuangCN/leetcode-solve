package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/12
 * 538.把二叉搜索树转换为累加树
 */
public class $538_convertBST {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    int val;

    public TreeNode convertBST(TreeNode root) {
        travel(root);
        return root;
    }

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        travel(root.right);
        val += root.val;
        root.val = val;
        travel(root.left);
    }

}
