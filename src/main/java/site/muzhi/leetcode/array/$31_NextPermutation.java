package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2020/11/10
 * @description 下一个排列
 */
public class $31_NextPermutation {
    /**
     * 双指针
     * 1.首先从后向前查找第一个顺序对 (i,i+1)(i,i+1)，满足 a[i] < a[i+1]a[i]<a[i+1]。
     * 这样「较小数」即为 a[i]a[i]。此时 [i+1,n)[i+1,n) 必然是下降序列。
     * 2.如果找到了顺序对，那么在区间 [i+1,n)[i+1,n) 中从后向前查找第一个元素 j，
     * j 满足 a[i] < a[j]a[i]<a[j]。这样「较大数」即为 a[j]a[j]。
     * 3.交换 a[i]a[i] 与 a[j]a[j]，此时可以证明区间 [i+1,n)[i+1,n) 必为降序。
     * 我们可以直接使用双指针反转区间 [i+1,n)[i+1,n) 使其变为升序，而无需对该区间进行排序。
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        // 从右向左寻找第一个较小数，即nums[i]<nums[i+1]
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }
        // 从右向左寻找另一个较大数，即nums[right]>nums[left]
        if (left >= 0) {
            int right = nums.length - 1;
            while (right >= 0 && nums[left] >= nums[right]) {
                right--;
            }
            // 找到，交换两个值
            swap(left, right, nums);
        }
        // 此时[left+1,nums.length+1] 区间内是递减序列，将此区间改为递增序列
        int m = left + 1, n = nums.length - 1;
        while (m < n) {
            swap(m, n, nums);
            m++;
            n--;
        }
    }

    private void swap(int x, int y, int[] nums) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
