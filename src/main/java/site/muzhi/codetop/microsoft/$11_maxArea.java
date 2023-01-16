package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/13
 * 11 盛最多水的容器
 */
public class $11_maxArea {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int area = Integer.MIN_VALUE;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            // 短板向中间移动
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
