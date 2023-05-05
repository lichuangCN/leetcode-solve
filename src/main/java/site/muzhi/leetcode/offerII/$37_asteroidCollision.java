package site.muzhi.leetcode.offerII;

import java.util.ArrayDeque;

/**
 * @author lichuang
 * @date 2023/05/05
 * 37.小行星碰撞
 */
public class $37_asteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return asteroids;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            if (queue.isEmpty()) {
                queue.addLast(curr);
                continue;
            }
            Integer prev = queue.peekLast();

            while (true) {
                // 不需要合并
                if (queue.isEmpty() || !merge(prev, curr)) {
                    queue.addLast(curr);
                    break;
                }
                // 需要合并
                prev = queue.pollLast();
                if (Math.abs(prev) < Math.abs(curr)) {
                    // 当前元素获胜, 继续向左比较
                    prev = queue.peekLast();
                } else if (Math.abs(prev) > Math.abs(curr)) {
                    // 左边元素获胜
                    queue.addLast(prev);
                    break;
                } else {
                    // do nothing 同归于尽
                    break;
                }
            }
        }

        // 结果
        int size = queue.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = queue.pollFirst();
        }
        return ans;
    }

    private boolean merge(int prev, int curr) {
        // 同向
        if ((prev < 0 && curr < 0) || (prev > 0 && curr > 0)) {
            return false;
        }
        // 不同向
        // 背对移动 永不相见
        if (prev < 0 && curr > 0) {
            return false;
        }
        // 面对面移动 必有生死
        return true;
    }
}
