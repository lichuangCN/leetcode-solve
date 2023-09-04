package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/10/26
 * @description 有多少小于当前数字的数字
 * <p>
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，
 * 其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 * <p>
 * 提示：
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class $1365_SmallerNumbersThanCurrent {

    /**
     * 1、暴力解决
     * 时间复杂度O(N*N)
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    /**
     * 2、哈希映射
     * 时间复杂度O(N+K<值域大小>)
     * 空间复杂度O(K) 另开辟了K大小的数组
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        // 根据提示，元素的值在[0,100]
        int[] numMap = new int[101];
        // 统计每个元素出现的次数
        for (int i = 0; i < nums.length; i++) {
            numMap[nums[i]]++;
        }
        // 统计numMap中元素小的个数
        for (int i = 1; i < numMap.length; i++) {
            numMap[i] += numMap[i - 1];
        }
        // 寻找对应位置的值
        for (int i = 0; i < nums.length; i++) {
            // nums[i]对应的值应该是numMap[nums[i]-1]]的值
            // 比如:nums[i]=3,对应的应该是numMap[2]的值
            res[i] = (nums[i] == 0) ? 0 : numMap[nums[i] - 1];
        }
        return res;
    }
}
