package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/19
 * 82.删除排序链表中的重复元素
 */
public class $82_deleteDuplicates {

    class ListNode {
        int val;
        ListNode next;
    }

    // 输入：head = [1,1,1,2,3,3,4,5,5]
    // 输出：[2,4]
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentry = new ListNode(), tail = sentry, curr = head;
        while (curr != null) {
            // 定位需要提取的元素
            if (curr.next == null || curr.val != curr.next.val) {
                tail.next = curr;
                tail = tail.next;
            }

            // 过滤重复元素
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            // 此时curr指向重复元素的最后一个, 需要向后移动
            curr = curr.next;
        }
        tail.next = null;
        return sentry.next;
    }
}
