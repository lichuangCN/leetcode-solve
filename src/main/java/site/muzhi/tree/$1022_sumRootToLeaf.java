package site.muzhi.tree;

/**
 * @author lichuang
 * @date 2021/06/24
 * @description 1022. 从根到叶的二进制数之和
 * <p>
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class $1022_sumRootToLeaf {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        return count(root, 0);
    }

    private int count(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum = sum * 2 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return count(node.left, sum) + count(node.right, sum);
    }
}

