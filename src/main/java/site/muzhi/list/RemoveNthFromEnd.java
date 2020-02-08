package site.muzhi.list;

/**
 * Author: lichuang
 * Date: Create in 14:17 2019/11/16
 * Description:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定的 n 保证是有效的。
 * 示例:
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5
 * 思路：
 * 因为是单链表结构，设立三个指针
 * index：指向要移除的元素的上一个元素
 * left：指向要移除的元素
 * right：right指针与left指针之间的间隔为n-1,right指针用于检测是否走到链表尽头
 *
 * 三个指针每次向右移动一位
 *
 * 当right指向链表最后一个元素的时候,此时left指针指向要移除的元素
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode list = removeNthFromEnd(head, 5);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        // 初始化指针位置
        ListNode index = null, left = head, right = head;
        // 设置左右指针之间的间隔为 n-1
        for (int i = 0; i < n - 1; i++) {
            right = right.next;
        }

        // 考虑特殊情况,移除的是第一个元素
        if (right.next == null) {
            return left.next;
        }
        // 删除的是链表中非第一个的元素
        while (right.next != null) {
            index = left;
            right = right.next;
            left = left.next;
        }
        // 移除选中的元素
        index.next = left.next;
        return head;
    }
}
