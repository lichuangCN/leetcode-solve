package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/13
 * @description 206. 反转链表
 * <p>
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class $206_reverseList {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverse(head);
    }

    /**
     * 递归
     */
    public ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }
        // 1 2 3 4
        // ...
        // 1 2 ->[3] 4 3
        // ...
        // 4 3 2 1
        ListNode head = reverse(node.next);
        // 当前节点 node 实际指向的是尾节点
        node.next.next = node;
        node.next = null;
        return head;
    }



    /**
     * 迭代
     */
    public ListNode reverseList_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //   1 2 3 4
        // 0 2 1
        ListNode dumpy = new ListNode(),pointer = head;
        while (pointer != null) {
            ListNode next = dumpy.next;
            dumpy.next = pointer;
            pointer = pointer.next;
            dumpy.next.next = next;
        }
        return dumpy.next;
    }

}
