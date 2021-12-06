package site.muzhi.leetcode.tree;

/**
 * @author lichuang
 * @date 2021/06/24
 * @description 700. 二叉搜索树中的搜索
 * <p>
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class $700_searchBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
