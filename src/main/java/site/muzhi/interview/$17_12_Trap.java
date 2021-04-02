package site.muzhi.interview;

/**
 * @author lichuang
 * @date 2021/04/02
 * @description 面试题 17.21. 直方图的水量
 * <p>
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 */
public class $17_12_Trap {

    /**
     * 暴力解法
     * <p>
     * 以列为处理单位
     *
     * @param height
     * @return
     */
    public int trap_1(int[] height) {
        int res = 0, len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int curr = height[i];

            int l = Integer.MIN_VALUE;
            // 向左寻找
            for (int j = i - 1; j >= 0; j--) {
                l = Math.max(height[j], l);
            }
            if (l <= curr) {
                continue;
            }
            // 向右寻找
            int r = Integer.MIN_VALUE;
            for (int j = i + 1; j <= len - 1; j++) {
                r = Math.max(height[j], r);
            }
            if (r <= curr) {
                continue;
            }

            res += Math.min(l, r) - curr;
        }

        return res;
    }

    /**
     * 双指针
     * <p>
     * 以行为处理单位
     *
     * @param height
     * @return
     */
    public int trap_2(int[] height) {
        int sum = 0;
        int len = height.length;
        for (int i : height) {
            sum += i;
        }

        int left = 0, right = len - 1, h = 1, v = 0;
        while (left <= right) {
            while (left <= right && height[left] < h) {
                left++;
            }
            while (left <= right && height[right] < h) {
                right--;
            }
            h++;
            v += right - left + 1;
        }
        return v - sum;
    }
}
