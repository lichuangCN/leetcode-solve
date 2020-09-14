package site.muzhi.list;

/**
 * @author lichuang
 * @date 2020/09/13
 * @description 排序链表
 * <p>
 * 在 O(n log n) 时间复杂度对链表进行排序
 * 递归方式,空间复杂度 O(logn)
 */
public class $148_SortList_1 {

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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // pre 用于处理偶数情况时指向上一半的最后一个元素
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 截断
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }

    /**
     * 递归合并两个链表
     *
     * @param L1
     * @param L2
     * @return
     */
    private ListNode merge(ListNode L1, ListNode L2) {
        if (L1 == null) {
            return L2;
        }
        if (L2 == null) {
            return L1;
        }
        if (L1.val <= L2.val) {
            L1.next = merge(L1.next, L2);
            return L1;
        } else {
            L2.next = merge(L1, L2.next);
            return L2;
        }
    }
}
