package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/07/21
 * 239.滑动窗口最大值
 */
public class $239_maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {


        int len = nums.length;
        int[] ans = new int[len - k + 1];

        // 非递减序列
        Deque<Integer> queue = new ArrayDeque<>(k);
        for (int i = 0; i < len; i++) {
            int val = nums[i];

            // 左侧窗口将要移除的元素nums[i-k+1] 如果是最大值
            if (i >= k && queue.peekFirst() == nums[i - k]) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < val) {
                queue.pollLast();
            }
            queue.addLast(val);

            if (i >= k - 1) {
                ans[i - k + 1] = queue.peekFirst();
            }
        }
        return ans;
    }
}
