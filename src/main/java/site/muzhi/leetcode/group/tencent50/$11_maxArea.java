package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/23
 * 11.盛最多水的容器
 */
public class $11_maxArea {

    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
