package site.muzhi.more;

import java.util.*;

/**
 * @author lichuang
 * @date 2020/10/31
 * @description O(1) 时间插入、删除和获取随机元素 - 允许重复
 */
public class $381_RandomizedCollection {
    class RandomizedCollection {

        private Map<Integer, Set<Integer>> idxMap;
        private List<Integer> nums;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            idxMap = new HashMap<Integer, Set<Integer>>();
            nums = new ArrayList<Integer>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            nums.add(val);
            // 重复元素的下标集合
            Set<Integer> idxSet = idxMap.getOrDefault(val, new HashSet<Integer>());
            // 新增元素在列表最后一位
            idxSet.add(nums.size() - 1);
            idxMap.put(val, idxSet);
            // 如果重复，set集合大小肯定大于1
            return idxSet.size() == 1;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!idxMap.containsKey(val)) {
                return false;
            }
            // 获取这个元素的一个下标值(可能有多个，取第一个就够)
            Integer idx = idxMap.get(val).iterator().next();
            // 交换此元素与最后一个元素的位置
            Integer lastNum = nums.get(nums.size() - 1);
            nums.set(idx, lastNum);
            // 移除要删除元素的索引
            idxMap.get(val).remove(idx);
            // 更新最后一个元素的坐标集合
            idxMap.get(lastNum).remove(nums.size() - 1);
            // 如果是移除的最后一个元素，不需要重新添加
            if (idx < nums.size() - 1) {
                idxMap.get(lastNum).add(idx);
            }
            // 如果此元素移除后没有重复值，将此元素从索引中移除
            if (idxMap.get(val).size() == 0) {
                idxMap.remove(val);
            }
            // 从元素集合中移除元素
            nums.remove(nums.size() - 1);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return nums.get((int) (Math.random() * nums.size()));
        }
    }
}
