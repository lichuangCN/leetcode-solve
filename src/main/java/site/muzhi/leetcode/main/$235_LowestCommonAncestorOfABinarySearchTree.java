package site.muzhi.leetcode.main;

/**
 * @author: lichuang
 * @date: 2020/03/11
 * @description: TODO
 */

public class $235_LowestCommonAncestorOfABinarySearchTree {
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
     * 适用于寻找所有二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 找到节点q或p
        if (root == q || root == p) {
            return root;
        }
        // 检测当前节点的左子树
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        // p,q两个节点分别处于当前节点两侧
        if (leftNode != null && rightNode != null) {
            return root;
        }
        // p,q两个节点分别处于当前节点右侧
        if (leftNode == null && rightNode != null) {
            return rightNode;
        }
        // p,q两个节点分别处于当前节点左侧
        if (leftNode != null && rightNode == null) {
            return leftNode;
        }

        // 否则未找到
        return null;
    }

    /**
     * 针对搜索二叉树的另一种方法
     * 1.p和q的val值小于当前节点node的val值，表明p和q在node左侧
     * 2.p和q的val值大于当前节点node的val值，表明p和q在node右侧
     * 3.如果不满足上面两个，则p和q分散在当前节点node的两侧
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        while (node != null) {
            int value = node.val;
            // 如果p和q的值均小于当前节点的值，表明p和q节点在当前值左侧
            if (p.val < value && q.val < value) {
                node = node.left;
            } else if (p.val > value && q.val > value) {
                // 如果p和q的值均大于当前节点的值，表明p和q节点在当前值右侧
                node = node.right;
            } else {
                // 此时p和q分别在当前节点两侧，当前节点为最近公共祖先节点
                return node;
            }
        }
        return null;
    }

}
