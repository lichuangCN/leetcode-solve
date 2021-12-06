package site.muzhi.leetcode.cla.interview.chapter4;

/**
 * @author lichuang
 * @date 2021/04/26
 * @description 删除链表中的节点
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xadve1/
 */
public class $7_deleteNode {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        // 我变成你，再把你干掉，我就干掉了我自己
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
