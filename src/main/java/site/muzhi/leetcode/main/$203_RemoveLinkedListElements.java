package site.muzhi.leetcode.main;

/**
 * @author: LiChuang
 * @date: 2020/03/03
 * @description: 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class $203_RemoveLinkedListElements {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 虚拟头节点和尾指针
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        while (head != null) {
            // 非目标值时，将此节点加入到新链表中
            if (head.val != val) {
                tail.next = head;
                tail = head;
            }
            head = head.next;
        }
        // 处理尾结点的指针
        tail.next = null;
        return newHead.next;
    }
}
