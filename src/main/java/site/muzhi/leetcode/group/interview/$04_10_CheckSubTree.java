package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/02/26
 * @description 检查子树
 *
 * 1.先寻找相同的根节点
 * 2.找到根节点后比较两颗树是否相同
 */
public class $04_10_CheckSubTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return false;
        }
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return isSame(t1, t2);
        } else {
            return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
        }
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
