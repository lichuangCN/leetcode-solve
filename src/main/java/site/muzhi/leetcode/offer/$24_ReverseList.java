package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/10/10
 * @description 剑指 Offer 24. 反转链表
 * <p>
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class $24_ReverseList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 双指针法
     */
    public ListNode reverseList(ListNode head) {
        ListNode t = new ListNode(0);
        while (head != null) {
            ListNode m = t.next;
            ListNode n = head.next;
            t.next = head;
            head = n;
            t.next.next = m;
        }
        return t.next;
    }

    /**
     * 递归解法
     * 参考思路：
     * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/kan-bu-dong-di-gui-de-kan-guo-lai-xi-wan-1akq/
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        // head.next 实际指向已经是反转后的链表的尾结点
        // head.next.next = head 即将当前节点添加大反转后的节点尾部
        head.next.next = head;
        // 避免成环
        head.next = null;
        return node;
    }
}
