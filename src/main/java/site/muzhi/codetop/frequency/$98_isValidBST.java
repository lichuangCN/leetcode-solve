package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/26
 * 98.验证二叉搜索树
 */
public class $98_isValidBST {
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    Integer pre;

    public boolean isValidBST(TreeNode root) {
        return travel(root);
    }

    /**
     * 中序遍历 单调非递减序列
     */
    private boolean travel(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean left = travel(node.left);
        //
        boolean curr = pre != null && node.val <= pre;
        if (!left || curr) {
            return false;
        }
        pre = node.val;
        return travel(node.right);
    }
}
