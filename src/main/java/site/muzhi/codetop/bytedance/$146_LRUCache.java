package site.muzhi.codetop.bytedance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lichuang
 * @date 2024/03/19
 * 146. LRU缓存机制
 */
public class $146_LRUCache {
    class LRUCache {

        class Node {
            int key, value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, Node> nodeMap;
        LinkedList<Node> queue;
        int capacity;

        public LRUCache(int capacity) {
            nodeMap = new HashMap<>();
            queue = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = nodeMap.get(key);
            if (node == null) {
                return -1;
            }
            queue.remove(node);
            queue.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = nodeMap.get(key);
            if (node == null) {
                if (queue.size() == this.capacity) {
                    Node last = queue.removeLast();
                    nodeMap.remove(last.key);
                }
                node = new Node(key, value);
                nodeMap.put(key, node);
                queue.addFirst(node);
            } else {
                queue.remove(node);
                node.value = value;
                queue.addFirst(node);
            }
        }
    }
}
