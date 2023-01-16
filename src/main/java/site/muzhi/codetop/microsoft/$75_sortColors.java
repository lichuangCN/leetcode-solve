package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/16
 * 75 颜色分类
 */
public class $75_sortColors {

    public void sortColors(int[] nums) {
        // 0 红色 1 白色 2 蓝色
        if (nums == null || nums.length == 0) {
            return;
        }
        // 统计出现的次数
        int r = 0, w = 0, b = 0, p = 0;
        for (int num : nums) {
            if (num == 0) {
                r++;
            } else if (num == 1) {
                w++;
            } else {
                b++;
            }
        }

        // 重置赋值
        for (int i = 0; i < r; i++) {
            nums[p++] = 0;
        }
        for (int i = 0; i < w; i++) {
            nums[p++] = 1;
        }
        for (int i = 0; i < b; i++) {
            nums[p++] = 2;
        }
    }
}
