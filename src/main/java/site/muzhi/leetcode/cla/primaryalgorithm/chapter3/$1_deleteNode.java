package site.muzhi.leetcode.cla.primaryalgorithm.chapter3;

/**
 * @author lichuang
 * @date 2021/05/19
 * @description 删除链表中的节点
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
 */
public class $1_deleteNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
