package site.muzhi.list;

/**
 * @author: LiChuang
 * @date: 2020/03/01
 * @description:
 */
public class $24_SwapNodesInPairs {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 非递归写法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        // 设一个节点作为两个交换节点的前一个节点
        ListNode tmp = pre;
        // 要交换的两个节点非空
        while (tmp.next != null && tmp.next.next != null) {
            ListNode first = tmp.next;
            ListNode second = tmp.next.next;
            // 交换节点顺序
            first.next = second.next;
            second.next = first;
            tmp.next = second;
            tmp = first;
        }
        return pre.next;
    }

    /**
     * 神奇的递归写法，我整个人都懵逼了
     * 1.终止条件：当前节点或当前节点的下一个节点为空
     * 2.执行内容：（交换位置）head节点指向后续链表，next节点指向当前head节点
     * 3.返回结果：交换后节点后链表的头节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        // 要交换的两个节点中任意一个元素为null
        if (head == null || head.next == null) {
            return head;
        }
        // head为第一个交换元素，next为第二个交换元素
        ListNode next = head.next;
        // 交换后的第二个元素的指向下一个节点
        // 递归处理后续链表
        head.next = swapPairs2(next.next);
        // 交换，第二个元素指向第一个元素
        next.next = head;
        return next;
    }
}
