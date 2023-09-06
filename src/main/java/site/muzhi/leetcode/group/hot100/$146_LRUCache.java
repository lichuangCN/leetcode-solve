package site.muzhi.leetcode.group.hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/09/06
 * 146.LRU缓存
 */
public class $146_LRUCache {
    class LRUCache {

        class Node {
            int key, val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        LinkedList<Node> queue;
        int capacity;
        Map<Integer, Node> keyMap;

        public LRUCache(int capacity) {
            this.queue = new LinkedList<>();
            this.capacity = capacity;
            this.keyMap = new HashMap<>();
        }

        public int get(int key) {
            if (!keyMap.containsKey(key)) {
                return -1;
            }
            Node node = keyMap.get(key);
            queue.remove(node);
            queue.add(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (keyMap.containsKey(key)) {
                Node node = keyMap.get(key);
                node.val = value;
                queue.remove(node);
                queue.add(node);
                return;
            }
            if (queue.size() == capacity) {
                Node node = queue.remove();
                keyMap.remove(node.key);
            }
            Node node = new Node(key, value);
            queue.add(node);
            keyMap.put(key, node);
        }
    }
}
