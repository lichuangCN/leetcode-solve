package site.muzhi.leetcode.list;

/**
 * @author: LiChuang
 * @date: 2020/03/03
 * @description: 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。
 * 已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 */
public class $1290_ConvertBinaryNumberInALinkedListToInteger {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 通过位运算计算
     *
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            //等价于
            // result = (result << 1) + head.val;
            head = head.next;
        }
        return result;
    }
}
