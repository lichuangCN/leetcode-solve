package site.muzhi.interview;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2021/02/25
 * @description 后继者
 */
public class $04_06_InorderSuccessor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 如果当前节点时目标节点，则其后继节点是当前节点的右子树的最左节点
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor_1(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        // 如果p节点无右子树，那么prev应该指向p的父节点
        TreeNode curr = root, prev = null;
        while (curr != null && curr.val != p.val) {
            if (curr.val > p.val) {
                curr = curr.right;
            } else {
                prev = curr;
                curr = curr.left;
            }
        }

        // 寻找p节点的后继节点，curr == p
        if (curr.right == null) {
            return prev;
        } else {
            // 寻找p节点右子树的最左节点
            curr = curr.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
    }


    /**
     * 中序遍历，当前驱节点last==p时，curr指向其后继节点
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode last = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.addLast(curr);
                curr = curr.left;
            }
            curr = stack.removeLast();
            if (last != null && last.val == p.val) {
                return curr;
            }
            last = curr;
            curr = curr.right;
        }
        return null;
    }


}
