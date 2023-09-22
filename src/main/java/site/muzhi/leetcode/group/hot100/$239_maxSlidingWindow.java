package site.muzhi.leetcode.group.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/09/22
 * 239.滑动窗口最大值
 */
public class $239_maxSlidingWindow {

    //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    //输出：[3,3,5,5,6,7]
    //解释：
    //滑动窗口的位置                最大值
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            if (i >= k && queue.peekFirst() == nums[i - k]) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < val) {
                queue.pollLast();
            }
            queue.addLast(val);

            if (i - k + 1 >= 0) {
                ans[i - k + 1] = queue.peekFirst();
            }
        }
        return ans;
    }
}
