package site.muzhi.leetcode.clazz.interview.chapter4;

/**
 * @author lichuang
 * @date 2021/04/26
 * @description 奇偶链表
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xa0a97/
 */
public class $8_oddEvenList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 1;
        ListNode odd = new ListNode(), even = new ListNode(), ptr = head, oddTail = odd, evenTail = even;
        while (ptr != null) {
            if ((count & 1) == 1) {
                oddTail.next = ptr;
                oddTail = oddTail.next;
            } else {
                evenTail.next = ptr;
                evenTail = evenTail.next;
            }
            ptr = ptr.next;
        }
        evenTail.next = null;
        oddTail.next = even.next;
        return odd.next;
    }
}
