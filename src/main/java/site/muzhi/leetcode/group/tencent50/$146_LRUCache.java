package site.muzhi.leetcode.group.tencent50;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/11/08
 * 146.LRU缓存
 */
public class $146_LRUCache {

    class LRUCache {

        class Node {
            int key, val;

            public Node() {
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        int capacity;
        Map<Integer, Node> kv;
        LinkedList<Node> queue;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            kv = new HashMap<>();
            queue = new LinkedList<>();
        }

        public int get(int key) {
            if (!kv.containsKey(key)) {
                return -1;
            }
            Node node = kv.get(key);
            queue.remove(node);
            queue.addLast(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (!kv.containsKey(key)) {
                if (queue.size() == capacity) {
                    Node node = queue.pollFirst();
                    kv.remove(node.key);
                }
                Node node = new Node(key, value);
                kv.put(key, node);
                queue.addLast(node);
            } else {
                Node node = kv.get(key);
                queue.remove(node);
                node.val = value;
                queue.addLast(node);
            }
        }
    }
}
