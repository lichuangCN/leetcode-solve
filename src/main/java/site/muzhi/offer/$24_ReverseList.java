package site.muzhi.offer;

/**
 * @author lichuang
 * @date 2020/10/10
 * @description 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class $24_ReverseList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head,next = null;
        ListNode tempHead = new ListNode(0);
        while (curr != null) {
            next = curr.next;
            curr.next = tempHead.next;
            tempHead.next = curr;
            curr = next;
        }
        return tempHead.next;
    }
}
