package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/14
 * 删除二叉搜索树中的节点
 */
public class $450_deleteNode {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
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

    /**
     * 需要考虑二叉搜索树的性质
     * 1.删除节点 > 当前节点：递归到右侧节点
     * 2.删除节点 < 当前节点：递归到左侧节点
     * 3.删除节点 = 当前节点：
     * a.左 或 右子树为空 直接返回 右 / 左子树
     * b.左右子树均非空
     * 方案1：将右子树拼接到左子树最右侧节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        // root.val == key
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        // 左子树最右侧节点
        TreeNode node = root.left;
        while (node.right != null) {
            node = node.right;
        }
        // 将右子树拼接到左子树最右侧节点
        node.right = root.right;
        return root.left;
    }
}
