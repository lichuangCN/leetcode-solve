package site.muzhi.leetcode.tree;

/**
 * @author: LiChuang
 * @date: 2020/02/27
 * @description: 给定一个二叉树，原地将它展开为链表。
 */
public class $114_FlattenBinaryTreeToLinkedList {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 全局指针
     */
    TreeNode pre = null;

    /**
     * 基于后序遍历，修改节点的右指针指向
     * 指定一个全局指针，指向后续遍历时指向的节点
     *
     * @param root
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten1(root.right);
        flatten1(root.left);
        // 当前节点的指针指向自己后序遍历的下一个节点
        root.right = pre;
        root.left = null;
        // 设置后序遍历的当前节点
        pre = root;
    }

    /**
     * 思想：遍历当前树的右子节点
     * <p>
     * 1.将左子树插入到右子树的地方
     * 2.将原来的右子树接到左子树的最右边节点
     * 3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     *
     * @param root
     */
    public void flatten2(TreeNode root) {
        // 当前右子节点非空
        while (root != null) {
            // 如果当前节点的左子节点为空
            if (root.left == null) {
                // 遍历下一个右子节点
                root = root.right;
            } else {
                // 临时节点，指向当前节点的右子节点
                TreeNode tmpRight = root.right;
                // 修改当前节点的右子树为左子树
                root.right = root.left;
                root.left = null;
                // 临时节点，用于寻找改变当前右子树的最右子节点
                TreeNode tmpRoot = root;
                while (tmpRoot.right != null) {
                    tmpRoot = tmpRoot.right;
                }
                // 拼接当前节点的右子树
                tmpRoot.right = tmpRight;
            }
        }
    }
}
