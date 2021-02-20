package site.muzhi.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/02/20
 * @description 层序遍历
 */
public class $04_03_ListOfDepth {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(tree);
        List<ListNode> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = new ListNode(-1), tail = head;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                ListNode listNode = new ListNode(node.val);
                tail.next = listNode;
                tail = tail.next;
            }
            levelList.add(head.next);
        }

        ListNode[] result = new ListNode[levelList.size()];
        for (int i = 0; i < levelList.size(); i++) {
            result[i] = levelList.get(i);
        }
        return result;
    }
}
