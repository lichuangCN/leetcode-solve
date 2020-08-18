package site.muzhi.list;

/**
 * @author lichuang
 * @date 2020/08/18
 * @description 有序链表转换二叉搜索树
 * <p>
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 *
 * 1.平衡树的构建是采用分治+递归的方式构建起来，并且树节点的构建顺序和list顺序一致
 * 2.
 *  r1 中的获取构建的树节点的值是通过遍历链表，找到当前递归区域的中间节点，再获取值
 *  r2 中引入中序遍历，在构建树节点的时，节点的构建顺序是按照list的顺序进行，因此可以通过全局的遍历获取
 *  当前构建的树节点的值，而不需要每次遍历链表
 */
public class $109_SortedListToBST_r2 {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
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

    /**
     * 遍历链表的指针
     */
    public ListNode globalHead;

    /**
     * 分治+中序遍历优化
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
        globalHead = head;
        TreeNode root = buildTree(0, getListLen(head) - 1);
        return root;
    }

    /**
     * 递归构建平衡树
     *
     * @param left
     * @param right
     * @return
     */
    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        // 中间节点的位置
        int middle = (left + right + 1) / 2;
        TreeNode treeNode = new TreeNode();
        treeNode.left = buildTree(left, middle - 1);
        // 遍历到当前树节点
        treeNode.val = globalHead.val;
        // 移动到下一位
        globalHead = globalHead.next;
        treeNode.right = buildTree(middle + 1, right);
        return treeNode;
    }

    /**
     * 获取链表长度
     *
     * @param head
     * @return
     */
    public int getListLen(ListNode head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }


}
