package site.muzhi.leetcode.ds;

/**
 * @author lichuang
 * @date 2021/03/13
 * @description
 */
public class DefHashSet {

    /**
     * 链表
     */
    class MyHashSet {

        class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        Node[] nodes;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            nodes = new Node[1000];
        }

        public void add(int key) {
            int idx = getIndex(key);
            Node loc = nodes[idx];

            // 当前位置没有值
            if (loc == null) {
                Node newNode = new Node(key);
                nodes[idx] = newNode;
                return;
            }
            // 判断是否已经存在此值
            Node pre = null;
            while (loc != null) {
                if (loc.val == key) {
                    return;
                }
                pre = loc;
                loc = loc.next;
            }
            Node newNode = new Node(key);
            // 尾插入法
            pre.next = newNode;

        }

        public void remove(int key) {
            int idx = getIndex(key);
            Node loc = nodes[idx];
            if (loc == null) {
                return;
            }
            Node pre = null;
            while (loc != null) {
                if (loc.val == key) {
                    if (pre == null) {
                        nodes[idx] = loc.next;
                    } else {
                        pre.next = loc.next;
                    }
                    return;
                }
                pre = loc;
                loc = loc.next;
            }
        }

        public boolean contains(int key) {
            int idx = getIndex(key);
            Node loc = nodes[idx];
            if (loc == null) {
                return false;
            }

            while (loc != null) {
                if (loc.val == key) {
                    return true;
                }
                loc = loc.next;
            }
            return false;
        }

        private int getIndex(int val) {
            int hashCode = Integer.hashCode(val);
            hashCode ^= hashCode >>> 16;
            return hashCode % nodes.length;
        }
    }
}
