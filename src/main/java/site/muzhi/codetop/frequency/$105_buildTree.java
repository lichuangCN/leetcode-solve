package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/25
 * 105.从前序与中序遍历序列构造二叉树
 */
public class $105_buildTree {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    // 输出: [3,9,20,null,null,15,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int val = preorder[preLeft];
        TreeNode node = new TreeNode(val);

        // 寻找中序遍历中当前节点的位置
        int idx = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }

        // 左侧节点总数
        int count = idx - inLeft;
        node.left = build(preorder, inorder, preLeft + 1, preLeft + count, inLeft, idx - 1);
        node.right = build(preorder, inorder, preLeft + count + 1, preRight, idx + 1, inRight);
        return node;
    }

}
