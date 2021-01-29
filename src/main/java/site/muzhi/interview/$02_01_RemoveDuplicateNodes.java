package site.muzhi.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2021/01/29
 * @description 移除重复节点
 */
public class $02_01_RemoveDuplicateNodes {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode pre = head, ptr = head.next;
        while (ptr != null) {
            if (!set.contains(ptr.val)) {
                set.add(ptr.val);
                pre.next = ptr;
                ptr = ptr.next;
                pre = pre.next;
            } else {
                // 不移动前驱指针
                ptr = ptr.next;
                pre.next = ptr;
            }
        }
        return head;
    }
}
