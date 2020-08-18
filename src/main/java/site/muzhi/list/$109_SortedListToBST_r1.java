package site.muzhi.list;

/**
 * @author lichuang
 * @date 2020/08/18
 * @description 有序链表转换二叉搜索树
 * <p>
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */
public class $109_SortedListToBST_r1 {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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
     * 分治
     *
     * @param head
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        TreeNode root = buildTree(head, null);
        return root;
    }

    /**
     * 递归构建平衡树
     *
     * @param left
     * @param right
     * @return
     */
    public TreeNode buildTree(ListNode left, ListNode right) {
        // 左右指针指向同一个节点，表明此节点无左右子树，返回null
        if (left == right) {
            return null;
        }
        ListNode middleNode = getMiddleNode(left, right);
        TreeNode root = new TreeNode(middleNode.val);
        root.left = buildTree(left, middleNode);
        root.right = buildTree(middleNode.next, right);
        return root;
    }

    /**
     * 快慢指针寻找中间节点 O(n)
     *
     * @param left
     * @param right
     * @return
     */
    public ListNode getMiddleNode(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;

        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
