package site.muzhi.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2021/02/21
 * @description
 */
public class $1438_LongestSubarray {

    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0, res = 0;
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        while (right < nums.length) {
            int val = nums[right];
            while (!max.isEmpty() && max.peekLast() < val) {
                max.removeLast();
            }
            while (!min.isEmpty() && min.peekLast() > val) {
                min.removeLast();
            }
            max.addLast(val);
            min.addLast(val);
            while (max.peekFirst() - min.peekFirst() > limit) {
                if (max.peekFirst() == nums[left]) {
                    max.removeFirst();
                }
                if (min.peekFirst() == nums[left]) {
                    min.removeFirst();
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
