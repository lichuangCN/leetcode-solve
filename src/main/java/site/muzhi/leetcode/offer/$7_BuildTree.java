package site.muzhi.leetcode.offer;

import java.util.HashMap;

/**
 * @author lichuang
 * @date 2020/12/12
 * @description 前序+中序重建二叉树
 */
public class $7_BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private HashMap<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        TreeNode root = build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        // 当前根节点在中序遍历中的位置
        Integer inOrderIdx = inOrderMap.get(val);
        // 左叶子节点
        TreeNode left = build(preorder, inorder, preLeft + 1, preLeft + inOrderIdx - inLeft, inLeft, inOrderIdx - 1);
        root.left = left;
        TreeNode right = build(preorder, inorder, preLeft + inOrderIdx - inLeft + 1, preRight, inOrderIdx + 1, inRight);
        root.right = right;
        return root;
    }

}
