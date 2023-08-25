package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/01/29
 * @description 删除中间节点
 */
public class $02_03_DeleteNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // node 是要被删除的节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
