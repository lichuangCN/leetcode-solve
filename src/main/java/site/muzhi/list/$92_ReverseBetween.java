package site.muzhi.list;

/**
 * @author lichuang
 * @date 2021/03/18
 * @description
 */
public class $92_ReverseBetween {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;


        int len = right - left;

        while (--left > 0) {
            pre = pre.next;
        }
        ListNode cur = pre.next, nex = cur.next;

        for (int i = 0; i < len; i++) {
            ListNode next = nex.next;
            nex.next = cur;
            cur = nex;
            nex = next;
        }
        pre.next.next = nex;
        pre.next = cur;
        return dummy.next;
    }

}
