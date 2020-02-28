package site.muzhi.list;

import java.util.HashMap;

/**
 * @author: LiChuang
 * @date: 2020/02/15
 * @description: 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的 深拷贝。 
 * <p>
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 */
public class $138_CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 核心思想：新旧节点之间通过Map形成映射关系，原链表上的逻辑关系可以通过Map映射到新节点
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // key 原链表节点 value 新链表节点
        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node curr = head;
        // 创建新节点
        while (curr != null) {
            nodeMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        // 连接新节点
        curr = head;
        while (curr != null) {
            // 获取原节点对应的新节点
            Node newNode = nodeMap.get(curr);
            // 新节点的后续节点
            newNode.next = nodeMap.get(curr.next);
            /*
             *新节点的随机节点
             *节点的随机节点指针可能为空
             */
            if (curr.random == null) {
                newNode.random = null;
            } else {
                // 新节点随机指针指向的节点
                newNode.random = nodeMap.get(curr.random);
            }
            curr = curr.next;
        }
        // 新链表对应的头结点
        return nodeMap.get(head);
    }
}
