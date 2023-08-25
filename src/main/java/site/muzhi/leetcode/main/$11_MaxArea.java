package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2020/09/13
 * @description 盛最多水的容器
 */
public class $11_MaxArea {

    /**
     * 双指针法
     * 时间复杂度 O(n),因为只遍历了一次数组
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int area = 0;
        while (left < right) {
            int minH = Math.min(height[left], height[right]);
            area = Math.max(minH * (right - left), area);
            // 最小值向中间移动
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return area;
    }

    /**
     * 暴力枚举法
     * 时间复杂度O(n²)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }

        int length = height.length;
        int area = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int minH = Math.min(height[i], height[j]);
                area = Math.max(area, minH * (j - i));
            }
        }
        return area;
    }
}
