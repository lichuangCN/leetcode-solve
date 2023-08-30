package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/08/30
 * 75.颜色分类
 */
public class $75_sortColors {

    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0;
        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if (count0 <= i && i < count1 + count0) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    /**
     * 双指针
     */
    public void sortColors_2(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            // 因为初始 p2指向的位置不一定是2，需要向左寻找到第一个非2的元素
            while (p2 >= i && nums[i] == 2) {
                int t = nums[p2];
                nums[p2] = nums[i];
                nums[i] = t;
                p2--;
            }

            if (nums[i] == 0) {
                int t = nums[p0];
                nums[p0] = nums[i];
                nums[i] = t;
                p0++;
            }
        }
    }
}
