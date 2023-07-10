package site.muzhi.codetop.frequency;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/07/10
 * 146.LRU缓存
 */
public class $146_LRUCache {

    class Node {
        int key, val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class LRUCache {
        private LinkedList<Node> queue;
        private int capacity;
        private Map<Integer, Node> keyNodeMap;

        public LRUCache(int capacity) {
            queue = new LinkedList<>();
            keyNodeMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = keyNodeMap.get(key);
            if (node == null) {
                return -1;
            }
            queue.remove(node);
            queue.add(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = keyNodeMap.get(key);
            if (node != null) {
                node.val = value;
                queue.remove(node);
                queue.add(node);
                return;
            }
            if (queue.size() == this.capacity) {
                Node first = queue.removeFirst();
                keyNodeMap.remove(first.key);
            }
            node = new Node(key, value);
            queue.add(node);
            keyNodeMap.put(key, node);
        }
    }
}
