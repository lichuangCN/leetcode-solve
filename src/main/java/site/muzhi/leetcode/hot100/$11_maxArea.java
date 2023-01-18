package site.muzhi.leetcode.hot100;

/**
 * @author lichuang
 * @date 2023/01/18
 * 11.盛最多水的容器
 */
public class $11_maxArea {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            // 短板向中间移动：最后结果可能变大 ***
            // 长板向中间移动：最后结果一定变小
            if (height[right] > height[left]) {
                left++;
            } else {
                right++;
            }
        }
        return ans;
    }
}
