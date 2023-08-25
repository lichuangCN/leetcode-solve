package site.muzhi.leetcode.group.offerII;

import java.util.*;

/**
 * @author lichuang
 * @date 2023/04/10
 * 30.插入、删除和随机访问都是O(1)的容器
 */
public class $30_RandomizedSet {

    class RandomizedSet {

        private List<Integer> data;
        private Map<Integer, Integer> indexMap;
        private Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            data = new ArrayList<>();
            indexMap = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (indexMap.containsKey(val)) {
                return false;
            }
            data.add(val);
            indexMap.put(val, data.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!indexMap.containsKey(val)) {
                return false;
            }
            Integer idx = indexMap.get(val);
            // 将队尾元素移动到要移除元素位置
            Integer last = data.get(data.size() - 1);
            indexMap.put(last, idx);
            data.set(idx, last);

            // 移除元素
            indexMap.remove(val);
            // 移除队尾元素
            data.remove(data.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int r = random.nextInt(data.size());
            return data.get(r);
        }
    }
}
