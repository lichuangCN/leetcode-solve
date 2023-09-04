package site.muzhi.leetcode.main;

/**
 * Author: lichuang
 * Date: Create in 18:29 2019/11/13
 * Description:
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class $2_AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode header = new ListNode(0);
        ListNode cursor = header;

        ListNode c1 = l1;
        ListNode c2 = l2;
        // 用于满十进位
        int temp = 0;
        while (c1 != null && c2 != null) {
            // 相加和
            int sum = c1.val + c2.val + temp;
            // 进位值
            temp = sum / 10;
            // 创建新节点
            ListNode node = new ListNode(sum % 10);
            cursor.next = node;
            // 指针后移
            cursor = node;
            c1 = c1.next;
            c2 = c2.next;
        }

        // 如果链表1非空
        while (c1 != null) {
            ListNode node = null;
            // 创建新节点
            if (temp == 0) {
                node = new ListNode(c1.val);
            } else {
                // 有进位
                node = new ListNode((c1.val + 1) % 10);
                temp = (c1.val + 1) / 10;
            }
            cursor.next = node;
            cursor = node;
            c1 = c1.next;
        }

        // 如果链表2非空
        while (c2 != null) {
            ListNode node = null;
            // 创建新节点
            if (temp == 0) {
                node = new ListNode(c2.val);
            } else {
                // 有进位
                node = new ListNode((c2.val + 1) % 10);
                temp = (c2.val + 1) / 10;
            }
            cursor.next = node;
            cursor = node;
            c2 = c2.next;
        }

        // 求和位数增加一位的情况
        if (c1 == null && c2 == null && temp != 0) {
            // 创建新节点
            ListNode node = new ListNode(1);
            cursor.next = node;
        }
        // 返回移除头结点的链表
        ListNode listNode = header.next;
        return listNode;
    }
}


