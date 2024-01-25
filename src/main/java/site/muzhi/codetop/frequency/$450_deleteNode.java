package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2024/01/25
 * 450.删除二叉搜索树中的节点
 */
public class $450_deleteNode {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

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

        // 将root节点的右侧子树拼接到root左侧子树最右节点
        TreeNode node = root.left;
        while (node.right != null) {
            node = node.right;
        }
        node.right = root.right;
        return root.left;
    }
}
