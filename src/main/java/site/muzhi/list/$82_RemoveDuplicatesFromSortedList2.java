package site.muzhi.list;

/**
 * @author: LiChuang
 * @date: 2020/03/02
 * @description: 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class $82_RemoveDuplicatesFromSortedList2 {
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
     * 一次遍历，通过比较[pre][cur][cur.next]三个节点的值
     * 即如果当前元素时唯一不重复的元素，则其余其前后两个节点的值时不同的
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 链表元素个数为0或1
        if (head == null || head.next == null) {
            return head;
        }
        // 此节点指向链表截取后的头节点
        ListNode node = new ListNode(0);
        // 新链表的尾指针，cur：遍历的当前节点
        ListNode tail = node, cur = head;
        // 遍历当前节点的前驱节点
        ListNode pre = null;
        while (cur != null) {
            // 处理链表头部
            if (pre == null) {
                // 第一个元素和第二个元素是否相等
                if (cur.val != cur.next.val) {
                    // 不相等，则将第一个节点加入新链表
                    tail.next = cur;
                    tail = cur;
                }
                // 否则继续向后遍历
                pre = cur;
                cur = cur.next;
                continue;
            }
            // 如果当前节点与前驱和后继节点均不同，则加入新链表
            if (cur.next != null && cur.val != pre.val && cur.val != cur.next.val) {
                tail.next = cur;
                tail = cur;
            }
            // 处理链表尾部
            if (cur.next == null && cur.val != pre.val) {
                tail.next = cur;
                tail = cur;
            }
            // 否则继续向后遍历
            pre = cur;
            cur = cur.next;
        }
        // 处理最后的节点的指针为空
        tail.next = null;
        return node.next;
    }

    /**
     * 递归写法
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        // 当当前节点与后继节点值相同时
        if (head.val == next.val) {
            // 遍历完当前重复的节点
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            // 因为当前节点时重复元素的节点，所以当前节点要丢弃，并重新赋值为下一个非重复元素的节点
            head = deleteDuplicates2(next);
        } else {
            // 保留当前元素节点，并指向下一个费重复元素节点
            head.next = deleteDuplicates2(next);
        }
        return head;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates_3(ListNode head) {
        ListNode dumpy = new ListNode(0);
        ListNode tail = dumpy;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = head;
            }
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dumpy.next;
    }

    /**
     * 探测法
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates_4(ListNode head) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode pre = dumpy, ptr = head;
        while (ptr != null && ptr.next != null) {
            // 向后探测
            if (ptr.val == ptr.next.val) {
                while (ptr != null && ptr.next != null && ptr.val == ptr.next.val) {
                    ptr = ptr.next;
                }
                pre.next = ptr.next;
                ptr = ptr.next;
            } else {
                pre.next = ptr;
                pre = ptr;
                ptr = ptr.next;
            }
        }
        return dumpy.next;
    }
}
