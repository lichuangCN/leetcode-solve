package site.muzhi.leetcode.main;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: lichuang
 * @date: 2020/03/07
 * @description: 请定义一个队列并
 * 实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */

public class $59_MaxQueue {
    class MaxQueue {

        // 存放所有队列元素
        private LinkedList<Integer> queue;
        // 优先级队列
        private PriorityQueue<Integer> maxQueue;

        public MaxQueue() {
            queue = new LinkedList<>();
            maxQueue = new PriorityQueue<>((x, y) -> y - x);
        }

        public int max_value() {
            return (queue.isEmpty()) ? -1 : maxQueue.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            maxQueue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            maxQueue.remove(queue.peek());
            return queue.poll();
        }
    }
}
