package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2024/01/23
 * 958.二叉树的完全性校验
 */
public class $958_isCompleteTree {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    // cnt: 节点总数
    // idx: 节点编号
    int cnt = 0, idx = 0;

    public boolean isCompleteTree(TreeNode root) {
        travel(root, 1);
        return cnt == idx;
    }

    private void travel(TreeNode root, int n) {
        if (root == null) {
            return;
        }
        // 统计节点个数
        cnt++;
        // 记录最大节点编号值
        idx = Math.max(idx, n);
        travel(root.left, n * 2);
        travel(root.right, n * 2 + 1);
    }
}
