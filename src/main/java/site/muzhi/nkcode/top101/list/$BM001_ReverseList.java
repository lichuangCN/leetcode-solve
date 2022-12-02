package site.muzhi.nkcode.top101.list;

/**
 * @author lichuang
 * @date 2022/12/02
 * @description BM1 反转链表
 */
public class $BM001_ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 迭代
     * 空间复杂度 o(1)
     * 时间复杂度 o(n)
     */
    public ListNode ReverseList_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1,2,3
        ListNode dumpy = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = dumpy.next;
            dumpy.next = head;
            head = next;
        }
        return dumpy.next;
    }

    /**
     * 递归
     * 空间复杂度 o(n)
     * 时间复杂度 o(n)
     */
    public ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        // 新的头结点
        ListNode newHead = ReverseList(head.next);
        // head.next 指向新链表的尾结点 将当前节点添加到尾结点
        head.next.next = head;
        // 重置尾结点
        head.next = null;
        return newHead;
    }

}
