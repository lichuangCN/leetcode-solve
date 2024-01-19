package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/03
 * 75.颜色分类
 */
public class $75_sortColors {

    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            // 处理 2
            while (nums[p1] == 2 && p2 >= p1) {
                swap(nums, p1, p2);
                p2--;
            }

            // 处理 0
            if (nums[p1] == 0) {
                swap(nums, p0, p1);
                p0++;
            }
            p1++;
        }
    }

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
