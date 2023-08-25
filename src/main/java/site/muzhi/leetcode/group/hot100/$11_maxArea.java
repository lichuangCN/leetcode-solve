package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/08/18
 * 11.盛最多水的容器
 */
public class $11_maxArea {

    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            // 短板向中间移动：最后结果可能变大
            // 长板向中间移动：最后结果一定变小
            if (height[left] <= right) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
