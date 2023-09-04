package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/04
 * 105.从前序和中序遍历构造二叉树
 */
public class $105_buildTree {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        // 中序遍历中 寻找根节点
        int rootVal = preorder[preLeft];
        int rootIdx = inLeft;
        for (rootIdx = inLeft; rootIdx < inRight; rootIdx++) {
            if (inorder[rootIdx] == rootVal) {
                break;
            }
        }
        int leftCount = rootIdx - inLeft;
        TreeNode root = new TreeNode(rootVal);
        TreeNode left = build(preorder, preLeft + 1, preLeft + leftCount, inorder, inLeft, rootIdx - 1);
        root.left = left;
        TreeNode right = build(preorder, preLeft + leftCount + 1, preRight, inorder, rootIdx + 1, inRight);
        root.right = right;
        return root;
    }
}
