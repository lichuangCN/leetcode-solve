package site.muzhi.ds;

/**
 * @author lichuang
 * @date 2021/03/14
 * @description
 */
public class DefHashMap {

    class MyHashMap {

        class Node {
            int key;
            int val;
            int hashCode;
            Node next;

            public Node(int key, int val, int hashCode) {
                this.key = key;
                this.val = val;
                this.hashCode = hashCode;
            }
        }


        Node[] table;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            table = new Node[16];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int idx = getIndex(key);
            Node loc = table[idx];
            int hashCode = getHashCode(key);
            if (loc == null) {
                table[idx] = new Node(key, value, hashCode);
                return;
            }
            Node pre = null;
            // 判断key值是否存在
            while (loc != null) {
                if (loc.key == key
                        && loc.hashCode == hashCode) {
                    loc.val = value;
                    return;
                }
                pre = loc;
                loc = loc.next;
            }
            pre.next = new Node(key, value, hashCode);
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int idx = getIndex(key);
            Node loc = table[idx];
            if (loc == null) {
                return -1;
            }
            while (loc != null) {
                if (loc.key == key) {
                    return loc.val;
                }
                loc = loc.next;
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int idx = getIndex(key);
            Node loc = table[idx];
            if (loc == null) {
                return;
            }
            Node pre = null;
            while (loc != null) {
                if (loc.key == key) {
                    if (pre == null) {
                        table[idx] = loc.next;
                    } else {
                        pre.next = loc.next;
                    }
                    return;
                }
                pre = loc;
                loc = loc.next;
            }
        }

        private int getIndex(int key) {
            int hashCode = Integer.hashCode(key);
            hashCode ^= hashCode >>> 16;
            return hashCode % table.length;
        }

        private int getHashCode(int key) {
            return key;
        }
    }
}
