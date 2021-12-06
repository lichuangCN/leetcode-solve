package site.muzhi.leetcode.tree;

/**
 * @author lichuang
 * @date 2020/08/27
 * @description 从前序与中序遍历序列构造二叉树
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class $105_BuildTree_1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }

        int length = preorder.length;
        TreeNode root = build(preorder, inorder, 0, length - 1, 0, length - 1);
        return root;
    }

    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int val = preorder[preLeft];
        TreeNode node = new TreeNode(val);
        // 寻找根节点在中序遍历中的位置
        int pos = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                pos = i;
                break;
            }
        }
        // 左子树节点数
        int leftCount = pos - inLeft;
        // 当前节点左子树区间
        TreeNode left = build(preorder, inorder, preLeft + 1, preLeft + leftCount, inLeft, pos - 1);
        node.left = left;

        // 右子树节点数
        int rightCount = inRight - pos;
        // 当前节点右子树区间
        TreeNode right = build(preorder, inorder, preLeft + leftCount + 1, preRight, pos + 1, inRight);
        node.right = right;

        return node;
    }

    ;
}
