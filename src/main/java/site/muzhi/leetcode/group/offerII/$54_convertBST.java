package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/05/15
 * 54.所有大于等于节点的值之和
 */
public class $54_convertBST {

    private int val = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        travel(root);
        return root;
    }

    public void travel(TreeNode node) {
        if (node == null) {
            return;
        }
        // 右 中 左 遍历
        travel(node.right);
        val += node.val;
        node.val = val;
        travel(node.left);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
