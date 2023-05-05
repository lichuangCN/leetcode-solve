package site.muzhi.leetcode.offerII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/05/05
 * 42.最近请求次数
 */
public class $42_RecentCounter {

    class RecentCounter {

        int TIME = 3000;
        Deque<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            while (!queue.isEmpty() && queue.peekFirst() + TIME < t) {
                queue.pollFirst();
            }
            queue.addLast(t);
            return queue.size();
        }
    }
}
