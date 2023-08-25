package site.muzhi.leetcode.group.offerII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/05/05
 * 41.滑动窗口平均值
 */
public class $41_MovingAverage {

    class MovingAverage {
        int windowSize;
        Deque<Integer> queue;
        int sum;

        public MovingAverage(int size) {
            this.windowSize = size;
            queue = new ArrayDeque<>();
            sum = 0;
        }

        public double next(int val) {
            if (queue.size() == this.windowSize) {
                // 移除第一个元素
                sum -= queue.pollFirst();
            }
            queue.addLast(val);
            sum += val;
            return (double) sum / queue.size();
        }
    }
}
