package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/02/23
 */
public class $9_numSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length < 0 || k <= 1) {
            return 0;
        }

        int ans = 0, prod = 1, left = 0, right = 0;
        while (right < nums.length) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            // 区间[L,R] 满足条件时，则 [L,R]区间的子集也是满足条件的
            // [L,R] [L+1,R] .... [R,R] 其中个数 = R - L + 1
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
