package site.muzhi.leetcode.main;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2024/01/04
 * 2487.从链表中移除节点
 */
public class $2487_removeNodes {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // ** 单调栈 ** //
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head, sentry = new ListNode(Integer.MAX_VALUE);
        sentry.next = head;
        // 栈内从栈底到栈顶是单调非递增序列（递减 或 相同值）
        Stack<ListNode> stack = new Stack<>();
        stack.push(sentry);
        while (curr != null) {

            // 小于当前值的节点
            while (curr.val > stack.peek().val) {
                stack.pop();
            }

            stack.peek().next = curr;
            stack.push(curr);
            curr = curr.next;
        }
        return sentry.next;
    }


    // ** 暴力解决方案 使用TreeMap类的特性来进行统计 ** //
    /*
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        TreeMap<Integer, Integer> nodeMap = new TreeMap<>((x, y) -> x - y);
        ListNode curr = head;
        while (curr != null) {
            int cnt = nodeMap.getOrDefault(curr.val, 0) + 1;
            nodeMap.put(curr.val, cnt);
            curr = curr.next;
        }

        ListNode sentry = new ListNode(), tail = sentry;
        curr = head;

        while (curr != null) {
            rmMap(nodeMap, curr.val);
            // 后续是否有严格大于当前值的节点
            if (nodeMap.higherKey(curr.val) == null) {
                tail.next = curr;
                tail = curr;
            }
            curr = curr.next;
        }
        return sentry.next;
    }

    private void rmMap(TreeMap<Integer, Integer> nodeMap, Integer key) {
        int minus = nodeMap.get(key) - 1;
        if (minus == 0) {
            nodeMap.remove(key);
        } else {
            nodeMap.put(key, minus);
        }
    }
     */
}
