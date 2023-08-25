package site.muzhi.leetcode.list;

/**
 * @author lichuang
 * @date 2020/11/16
 * @description 奇偶链表
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class $328_OddEvenList {
    /**
     * Definition for singly-linked list.
     */
    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = new ListNode(0);
        ListNode evenTail = evenHead;
        ListNode oddHead = new ListNode(0);
        ListNode oddTail = oddHead;
        ListNode ptr = head;
        boolean isEven = true;
        while (ptr != null) {
            if (isEven) {
                evenTail.next = ptr;
                evenTail = ptr;
                isEven = false;
            } else {
                oddTail.next = ptr;
                oddTail = ptr;
                isEven = true;
            }
            ptr = ptr.next;
        }
        oddTail.next = null;
        evenTail.next = oddHead.next;
        return evenHead.next;
    }
}
