package site.muzhi.tree;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2021/05/17
 * @description 993. 二叉树的堂兄弟节点
 * <p>
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class $993_isCousins {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        boolean fx = false, fy = false;
        TreeNode px = null, py = null;
        // [0]:父节点,[1]:当前节点
        LinkedList<TreeNode[]> list = new LinkedList<>();
        list.addLast(new TreeNode[]{null, root});
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode[] nodes = list.pollFirst();
                if (nodes[1].val == x) {
                    fx = true;
                    px = nodes[0];
                } else if (nodes[1].val == y) {
                    fy = true;
                    py = nodes[0];
                } else {
                    if (nodes[1].left != null) {
                        list.addLast(new TreeNode[]{nodes[1], nodes[1].left});
                    }
                    if (nodes[1].right != null) {
                        list.addLast(new TreeNode[]{nodes[1], nodes[1].right});
                    }
                }
            }
            // 找到一个即停止
            if (fx || fy) {
                break;
            }
        }
        return fx && fy && (px != py);
    }
}
