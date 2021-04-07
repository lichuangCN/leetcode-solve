package site.muzhi.hot100;

/**
 * @author lichuang
 * @date 2021/04/06
 * @description 42. 接雨水
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class $42_trap {

    /**
     * 双指针（以层为单位计算）
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int v = 0;
        for (int i : height) {
            v += i;
        }
        int left = 0, right = height.length - 1;
        int h = 1, s = 0;
        while (left <= right) {
            while (left <= right && height[left] < h) {
                left++;
            }
            while (left <= right && height[right] < h) {
                right--;
            }
            s += right - left + 1;
            h++;
        }
        return s - v;
    }
}
