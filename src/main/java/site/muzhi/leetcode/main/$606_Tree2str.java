package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/06/24
 * @description 606. 根据二叉树创建字符串
 * <p>
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
public class $606_Tree2str {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return root.val + "";
        }
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

}
