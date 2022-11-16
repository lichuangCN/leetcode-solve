package site.muzhi.codetop.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2022/11/16
 * @description 146. LRU 缓存
 * 双向队列
 * https://leetcode.cn/problems/lru-cache/solutions/12711/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
 */
public class $146_LRUCache {

    /**
     * 队列节点
     */
    class Node {
        int key, val;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 双端队列
     */
    class DoubleList {
        Node head, tail;
        int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            this.size = 0;
        }

        public void addLast(Node node) {
            node.pre = tail.pre;
            node.next = tail;

            tail.pre.next = node;
            tail.pre = node;
            size++;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public Node removeFirst() {
            if (head.next == null) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }
    }


    class LRUCache {

        DoubleList cache;
        int capacity;
        Map<Integer, Node> map;

        public LRUCache(int capacity) {
            cache = new DoubleList();
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            // 先删除 后新增
            cache.remove(node);
            cache.addLast(node);
            return node.val;
        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                // 先删除 后新增
                cache.remove(node);
                cache.addLast(node);
                return;
            }

            // 如果容量已经满了 先删除最不常用节点 即头节点
            if (cache.size() == this.capacity) {
                Node node = cache.removeFirst();
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            cache.addLast(node);
            map.put(key, node);
        }
    }
}
