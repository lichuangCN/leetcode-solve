package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/04
 * 99.恢复二叉搜索树
 */
public class $99_recoverTree {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 中序遍历 寻找两个递减对 将第一个递减对的大值和第二个递减对的小值进行交换
    // 如 4 2 3 1 , 递减对是 [4,2]、[3,1]，将 4 和 1 进行交换 => 1 2 3 4
    TreeNode first, second, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inOrder(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        // 第一个递减对
        if (first == null && prev.val > node.val) first = prev;
        // 第二个递减对
        if (first != null && prev.val > node.val) second = node;
        prev = node;
        inOrder(node.right);
    }
}
