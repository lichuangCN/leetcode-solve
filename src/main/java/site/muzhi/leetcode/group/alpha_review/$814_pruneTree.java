package site.muzhi.leetcode.group.alpha_review;

/**
 * @author lichuang
 * @date 2023/12/26
 * 814.二叉树剪枝
 */
public class $814_pruneTree {

    class TreeNode {
        int val;
        TreeNode left, right;
    }


    public TreeNode pruneTree(TreeNode root) {

        return travel(root);
    }

    private TreeNode travel(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = travel(node.left), right = travel(node.right);
        if (left == null) {
            node.left = null;
        }
        if (right == null) {
            node.right = null;
        }
        // 判断当前节点是否需要丢弃
        if (left == null && right == null) {
            return node.val == 0 ? null : node;
        }
        return node;
    }
}
