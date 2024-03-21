package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2024/01/23
 * 11.盛最多水的容器
 */
public class $11_maxArea {

    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int v = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, v);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
