package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/05/09
 * 49.从根节点到叶节点的路径数字之和
 */
public class $49_sumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return travel(0, root);
    }

    private int travel(int num, TreeNode node) {
        if (node == null) {
            return 0;
        }
        int curr = num * 10 + node.val;

        if (node.left == null && node.right == null) {
            return curr;
        }
        return travel(curr, node.left) + travel(curr, node.right);
    }

    class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;
    }
}
