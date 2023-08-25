package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2022/03/08
 * @description 剑指 Offer 26. 树的子结构
 * <p>
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class $26_IsSubStructure {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 根节点相同的情况
        if ((A.val == B.val) && travel(A.left, B.left) && travel(A.right, B.right)) {
            return true;
        }
        // B子树在A的左侧或者右侧
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 前序遍历
     */
    public boolean travel(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return travel(A.left, B.left) && travel(A.right, B.right);
    }
}
