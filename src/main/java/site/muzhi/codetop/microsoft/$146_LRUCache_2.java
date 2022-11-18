package site.muzhi.codetop.microsoft;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lichuang
 * @date 2022/11/18
 */
public class $146_LRUCache_2 {

    /**
     * 队列节点
     */
    class Node {
        int key, val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class LRUCache {

        LinkedList<Node> cache;
        Map<Integer, Node> keyMap;
        int capacity;

        public LRUCache(int capacity) {
            cache = new LinkedList();
            keyMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = keyMap.get(key);
            if (node == null) {
                return -1;
            }
            cache.remove(node);
            cache.addLast(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = keyMap.get(key);
            if (node != null) {
                node.val = value;
                cache.remove(node);
                cache.addLast(node);
                return;
            }
            if (cache.size() == this.capacity) {
                // 移除队首元素
                Node del = cache.removeFirst();
                keyMap.remove(del.key);
            }

            Node insert = new Node(key, value);
            cache.addLast(insert);
            keyMap.put(key, insert);
        }
    }
}
