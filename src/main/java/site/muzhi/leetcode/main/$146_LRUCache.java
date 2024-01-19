package site.muzhi.leetcode.main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lichuang
 * @date 2024/01/19
 * 146.LRU 缓存
 */
public class $146_LRUCache {
    class Node {
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {

        int capacity = 0;
        Map<Integer, Node> keyMap;
        LinkedList<Node> queue;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            keyMap = new HashMap<>();
            queue = new LinkedList<>();
        }

        public int get(int key) {
            Node node = keyMap.get(key);
            if (node == null) {
                return -1;
            }
            //
            queue.remove(node);
            queue.addLast(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = keyMap.get(key);
            if (node != null) {
                node.value = value;
                queue.remove(node);
                queue.addLast(node);
            } else {
                if (queue.size() == this.capacity) {
                    Node rm = queue.removeFirst();
                    keyMap.remove(rm.key);
                }
                Node ins = new Node(key, value);
                queue.addLast(ins);
                keyMap.put(key, ins);
            }
        }
    }
}
