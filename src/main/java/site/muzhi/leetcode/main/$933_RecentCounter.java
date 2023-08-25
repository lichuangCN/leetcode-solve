package site.muzhi.leetcode.array;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author lichuang
 * @date 2022/05/06
 * @description 933. 最近的请求次数
 * <p>
 * 滑动窗口：始终维护一个[t-3000,t]的队列
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 */
public class $933_RecentCounter {

    class RecentCounter {

        static final int TIME = 3000;

        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            // 如果之前的请求已经超过了 TIME 的指定的时间范围，则将相关请求从队列中移除
            while (!queue.isEmpty() && t - queue.peek() > TIME) {
                queue.poll();
            }
            queue.offer(t);
            return queue.size();
        }
    }
}
