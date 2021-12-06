package site.muzhi.leetcode.tree;

/**
 * @author lichuang
 * @date 2020/08/27
 * @description 从中序与后序遍历序列构造二叉树
 * <p>
 * 105、106还原二叉树，主要的是如何确定递归的边界值
 */
public class $106_BuildTree_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (postorder.length != inorder.length) {
            return null;
        }

        int length = postorder.length;

        return build(inorder, postorder, 0, length - 1, 0, length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight) {
            return null;
        }
        // 当前根节点
        int val = postorder[postRight];
        TreeNode node = new TreeNode(val);
        // 当前根节点在当前树中序的位置
        int pos = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                pos = i;
                break;
            }
        }

        // 右子树节点数
        int rightCount = inRight - pos;
        // 右子树
        TreeNode right = build(inorder, postorder, pos + 1, inRight, postRight - pos, postRight - 1);
        node.right = right;
        // 左子树
        TreeNode left = build(inorder, postorder, inLeft, pos - 1, postLeft, postRight - rightCount - 1);
        node.left = left;
        return node;
    }
}
