package site.muzhi.codetop.microsoft;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2022/12/01
 * @description 239. 滑动窗口最大值
 */
public class $239_maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        // 单调非递增序列
        LinkedList<Integer> queue = new LinkedList<>();
        // 滑动窗口 最左侧元素索引
        // r_idx - l_idx + 1 = k
        // r_idx 初始 = 0, 故 l_idx = 1 - k
        int l_idx = 1 - k, r_idx = 0;
        while (r_idx < nums.length) {
            // 滑动窗口右侧新加入元素
            int val = nums[r_idx];
            // 移除失效元素
            if (l_idx > 0 && queue.peekFirst() == nums[l_idx - 1]) {
                queue.removeFirst();
            }

            // 单调非递减队列
            while (!queue.isEmpty() && queue.peekLast() < val) {
                queue.removeLast();
            }
            queue.addLast(val);

            // 结果赋值，queue队首元素为当前窗口最大值
            if (l_idx >= 0) {
                ans[l_idx] = queue.peekFirst();
            }
            // 滑动窗口右移
            l_idx++;
            r_idx++;
        }
        return ans;
    }

}
