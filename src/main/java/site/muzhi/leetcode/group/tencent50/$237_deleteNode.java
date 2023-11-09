package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/08
 * 237.删除链表中的节点
 */
public class $237_deleteNode {

    class ListNode {
        int val;
        ListNode next;
    }

    public void deleteNode(ListNode node) {
        // 将下一个节点的值赋值到当前节点
        // 移除下一个节点
        node.val = node.next.val;
        node.next = node.next.next;

//        ListNode curr = node,prev = null;
//        while (curr.next != null) {
//            curr.val = curr.next.val;
//            prev = curr;
//            curr = curr.next;
//        }
//        prev.next = null;


    }
}
