package site.muzhi.tree;

/**
 * @author lichuang
 * @date 2020/09/01
 * @description 二叉搜索树中第K小的元素
 * <p>
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 */
public class $230_KthSmallest {
    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int res;
    int n = 0;

    /**
     * 中序遍历第k个元素
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    public void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        // 继续遍历左子树
        inOrder(node.left, k);
        n++;
        // 第k个
        if (n == k) {
            res = node.val;
            // 剪枝，停止递归
            return;
        }
        inOrder(node.right, k);
    }
}
