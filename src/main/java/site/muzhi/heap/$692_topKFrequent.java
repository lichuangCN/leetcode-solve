package site.muzhi.heap;

import java.util.*;

/**
 * @author lichuang
 * @date 2021/05/20
 * @description 692. 前K个高频单词
 * <p>
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class $692_topKFrequent {

    public List<String> topKFrequent(String[] words, int k) {
        // 1.统计次数
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // 小顶堆
        PriorityQueue<String> heap = new PriorityQueue<>((o1, o2) -> {
            if (countMap.get(o1).equals(countMap.get(o2))) {
                return o2.compareTo(o1);
            }
            return countMap.get(o1) - countMap.get(o2);
        });

        for (String word : countMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> list = new ArrayList<>(k);
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }

        Collections.reverse(list);
        return list;
    }
}
