package site.muzhi.leetcode.group.offer;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2022/02/23
 * @description 剑指 Offer 06. 从尾到头打印链表
 *
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class $6_ReversePrint {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> buffer = new Stack<>();
        ListNode ptr = head;
        while (ptr != null) {
            buffer.push(ptr.val);
            ptr = ptr.next;
        }

        int size = buffer.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = buffer.pop();
        }

        return ans;
    }
}
