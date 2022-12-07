package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/07
 * @description 160. 相交链表
 */
public class $160_getIntersectionNode {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;
        while (true) {
            // 如果有相交，currA 此时是相交节点
            // 如果不相交，currA 此时是空
            if (currA == currB) {
                break;
            }
            currA = (currA == null ? headB : currA.next);
            currB = (currB == null ? headA : currB.next);
        }
        return currA;
    }
}
