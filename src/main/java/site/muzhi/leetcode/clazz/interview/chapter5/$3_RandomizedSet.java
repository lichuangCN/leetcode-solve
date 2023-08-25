package site.muzhi.leetcode.clazz.interview.chapter5;

import java.util.*;

/**
 * @author lichuang
 * @date 2021/04/29
 * @description 常数时间插入、删除和获取随机元素
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xagm3s/
 */
public class $3_RandomizedSet {

    class RandomizedSet {

        private Map<Integer, Integer> map;
        private List<Integer> list;
        private Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            Integer idx = map.get(val);
            Integer lastVal = list.get(list.size() - 1);
            // 1.将最后一个元素放在要移除的元素的位置
            list.set(idx,lastVal);
            map.put(lastVal,idx);

            // 2.移除元素
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int idx = random.nextInt(list.size());
            return list.get(idx);
        }
    }
}
