package site.muzhi.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lichuang
 * @date 2020/08/19
 * @description 相同的树
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class $100_IsSameTree {
    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //return preOrderTraversal(p, q);
        //return deepthTraversal(p, q);
        return breadthTraversal(p, q);
    }

    /**
     * 前序遍历判断二叉树是否相同
     *
     * @param p
     * @param q
     * @return
     */
    public boolean preOrderTraversal(TreeNode p, TreeNode q) {
        // 同时为null,返回true
        if (p == null && q == null) {
            return true;
        }
        // 同时不为空并且值相同,再进行左右子树比较
        if (p != null && q != null && p.val == q.val) {
            boolean left = preOrderTraversal(p.left, q.left);
            if (!left) {
                return false;
            }
            boolean right = preOrderTraversal(p.right, q.right);
            if (!right) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * 深度优先遍历二叉树
     *
     * @param p
     * @param q
     * @return
     */
    public boolean deepthTraversal(TreeNode p, TreeNode q) {
        // 同时为null,表示节点相同,返回true
        if (p == null && q == null) {
            return true;
        }
        // 其中一个节点为null,此时两个节点不同
        if (q == null || q == null) {
            return false;
        }
        // 此时两个节点都不为null
        if (p.val != q.val) {
            return false;
        } else {
            // 继续深度遍历左右两侧子树
            boolean left = deepthTraversal(p.left, q.left);
            if (!left) {
                return false;
            }
            boolean right = deepthTraversal(p.right, q.right);
            if (!right) {
                return false;
            }
            return true;
        }
    }

    /**
     * 广度优先遍历
     *
     * @param p
     * @param q
     * @return
     */
    public boolean breadthTraversal(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        // p和q均非null
        Queue<TreeNode> queueP = new LinkedList<TreeNode>();
        Queue<TreeNode> queueQ = new LinkedList<TreeNode>();
        queueP.add(p);
        queueQ.add(q);
        while ((!queueP.isEmpty()) && (!queueQ.isEmpty())) {
            TreeNode nq = queueP.poll();
            TreeNode np = queueQ.poll();
            if (nq.val != np.val) {
                return false;
            }
            // 当前节点值相同，填充下一层节点
            // 左节点
            TreeNode leftQ = nq.left;
            TreeNode leftP = np.left;
            // 左侧节点一个为null,一个非null
            if (leftP == null ^ leftQ == null) {
                return false;
            }
            if (leftP != null) {
                queueP.add(leftP);
            }
            if (leftQ != null) {
                queueQ.add(leftQ);
            }
            // 右节点
            TreeNode rightQ = nq.right;
            TreeNode rightP = np.right;
            if (rightP == null ^ rightQ == null) {
                return false;
            }
            if (rightP != null) {
                queueP.add(rightP);
            }
            if (rightQ != null) {
                queueQ.add(rightQ);
            }
        }
        return queueP.isEmpty() && queueQ.isEmpty();
    }

}
