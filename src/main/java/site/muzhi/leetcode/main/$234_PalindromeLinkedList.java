package site.muzhi.leetcode.list;

import java.util.Stack;

/**
 * @author: LiChuang
 * @date: 2020/03/03
 * @description: 请判断一个链表是否为回文链表。
 */
public class $234_PalindromeLinkedList {
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


    /**
     * 翻转链表，翻转前半部分链表，并与后半部分链表比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        // 翻转后的链表的头节点
        ListNode preHead = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // 翻转链表
            ListNode tmp = slow.next;
            slow.next = preHead;
            preHead = slow;
            slow = tmp;
        }
        // 此时链表元素为奇数个，slow指向中间元素
        if (fast != null) {
            // 跳过中间元素
            slow = slow.next;
        }

        // 后段链表与前段反转后的链表进行比较
        while (slow != null) {
            if (slow.val != preHead.val) {
                return false;
            }
            slow = slow.next;
            preHead = preHead.next;
        }
        return true;
    }

    /**
     * 通过栈解决，将前半部分链表元素压入栈中，逐个弹出与后半链表中的元素比较
     * 通过快慢指针
     * 时间复杂度O(n)，空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此时链表元素为奇数个，slow指向中间元素
        if (fast != null) {
            // 跳过中间元素
            slow = slow.next;
        }
        // 与栈中元素比较
        while (!stack.isEmpty()) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
