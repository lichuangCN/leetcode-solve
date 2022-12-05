package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/05
 * @description 148. 排序链表
 */
public class $148_sortList {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        // 递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 拆分链表
        ListNode midNode = middleNode(head);
        // 因为是使用中间节点的next节点作为右侧链表的头结点，当链表长度 = 2时，划分后会出现 2，0 的情况，无限递归
        // 故在拆分链表时，需要获取中间节点的前置结点
        ListNode rightHead = midNode.next;
        // 拆分
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并
        return merge(left, right);
    }

    /**
     * 链表中间节点
     */
    private ListNode middleNode(ListNode head) {
        // 这段代码执行失败 都是寻找链表中间节点，好奇为啥会失败
        if (head == null || head.next == null) {
            return head;
        }
        // pre：标记slow指针的前一个节点
        // 当链表个数为偶数时，pre作为前半链表的尾部节点，slow作为后半链表的头结点，对半分开
        // 当链表个数为奇数时，slow作为中间节点，划分到后半链表的头节点
        ListNode slow = head, fast = head,pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

    /**
     * 有序链表合并
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode sentry = new ListNode(), curr = sentry;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        curr.next = head1 == null ? head2 : head1;
        return sentry.next;
    }
}
