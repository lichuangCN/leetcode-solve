package site.muzhi.interview;

/**
 * @author lichuang
 * @date 2021/04/01
 * @description 面试题 08.03. 魔术索引
 * <p>
 * https://leetcode-cn.com/problems/magic-index-lcci/
 */
public class $08_03_FindMagicIndex {
    /**
     * 暴力
     *
     * @param nums
     * @return
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 跳跃
     *
     * @param nums
     * @return
     */
    public int findMagicIndex_1(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                return i;
            }
            // 如果num[i]>i;
            // 则[i,nums[i]-1]区间均不会满足条件
            // 下一次查找应该是 从nums[num[i]]开始
            i = Math.max(i + 1, nums[i]);
        }
        return -1;
    }
}
