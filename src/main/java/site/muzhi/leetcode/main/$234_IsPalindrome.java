package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/10/23
 * @description 请判断一个链表是否为回文链表。
 *
 */
public class $234_IsPalindrome {

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

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 1.通过快慢指针找到中间值
        ListNode slow = head,fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 奇数节点时slow指向中间节点，偶数节点时指向前半截最后一个节点
        slow = slow.next;
        // 2.倒转后半截链表
        ListNode tempHead = new ListNode(0);
        while (slow != null) {
            // 记录临时头结点的next
            ListNode next = tempHead.next;
            // 新节点插入头结点后面
            tempHead.next = slow;
            slow = slow.next;
            // 将上次节点接入已经逆序的链表
            tempHead.next.next = next;
        }
        // 比较值
        ListNode halfHead = tempHead.next;
        while (halfHead != null) {
            if(halfHead.val != head.val) {
                return false;
            }
            halfHead = halfHead.next;
            head = head.next;
        }
        return true;
    }
}
