package site.muzhi.leetcode.list;

/**
 * @author: LiChuang
 * @date: 2020/02/08
 * @description: 编写一个程序，找到两个单链表相交的起始节点。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存
 * <p>
 * 算法思想：
 * 1.指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
 * 2.如果 pA 到了末尾，则 pA = headB 继续遍历
 * 3.如果 pB 到了末尾，则 pB = headA 继续遍历
 * 4.比较长的链表指针指向较短链表head时，长度差就消除了
 * 如此，只需要将最短链表遍历两次即可找到位置
 */
public class $160_IntersectionOfTwoLinkedLists {
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa == null ? headB : pa.next);
            pb = (pb == null ? headA : pb.next);
            // 终止条件:1. 两个链表不相交，则终止条件为pa=pb=null;2.两个链表相交，返回相交的节点
        }
        return pa;
    }
}
