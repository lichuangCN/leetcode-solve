package site.muzhi.codetop.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2024/03/19
 * 146. LRU缓存机制
 */
public class $146_LRUCache_2 {

    public static void main(String[] args) {
//        ["LRUCache","put","put","get","put","get","put","get","get","get"]
//			[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
//        ["LRUCache","put","get","put","get","get"]
//        [[1],[2,1],[2],[3,2],[2],[3]]

        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    public static class LRUCache {

        class Node {
            int key, value;
            Node prev, next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, Node> nodeMap;
        Node head, tail;
        int capacity;
        int size;

        public LRUCache(int capacity) {
            nodeMap = new HashMap<>();
            head = new Node();
            tail = head;
            this.capacity = capacity;
            this.size = 0;
        }

        public int get(int key) {
            Node node = nodeMap.get(key);
            if (node == null) {
                return -1;
            }
            if (node.prev == head) {
                return node.value;
            }

            if (node.next == null) {
                // 移除尾结点
                tail = node.prev;
                tail.next = null;
            } else {
                // 移除中间节点
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            // node节点到head节点
            Node next = head.next;
            node.next = next;
            next.prev = node;
            head.next = node;
            node.prev = head;
            return node.value;
        }

        public void put(int key, int value) {
            Node node = nodeMap.get(key);
            if (node != null) {
                get(key);
                head.next.value = value;
            } else {
                // 移除末尾节点
                if (this.size == this.capacity) {
                    Node drop = tail;
                    tail = drop.prev;
                    drop.prev.next = null;
                    nodeMap.remove(drop.key);
                    this.size -= 1;
                }
                node = new Node(key, value);
                nodeMap.put(key, node);
                Node next = head.next;
                node.next = next;
                if (next != null) {
                    next.prev = node;
                }
                if (head.next == null) {
                    tail = node;
                }
                head.next = node;
                node.prev = head;
                this.size += 1;
            }
        }
    }
}
