package site.muzhi.interview;

/**
 * @author lichuang
 * @date 2021/02/26
 * @description
 */
public class $04_12_PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return count(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int count(TreeNode node, int sum, int target) {
        if (node == null) {
            return 0;
        }
        sum += node.val;
        return (sum == target ? 1 : 0) + count(node.left, sum, target) + count(node.right, sum, target);
    }
}
