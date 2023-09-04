package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/11/12
 * @description 按奇偶排序数组 II
 * <p>
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 */
public class $922_SortArrayByParity_2 {

    /**
     * 原数组可以修改
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        if (A == null | A.length == 0) {
            return new int[0];
        }
        int even = 0, odd = 1;
        for (even = 0; even < A.length - 1; even += 2) {
            // 偶数
            if ((A[even] & 1) == 1) {
                // 偶数位是奇数，寻找奇数位是偶数的位置
                while ((A[odd] & 1) == 1) {
                    odd += 2;
                }
                // 交换
                int t = A[even];
                A[even] = A[odd];
                A[odd] = t;
            }
        }
        return A;
    }

    /**
     * 新数组
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {
        if (A == null | A.length == 0) {
            return new int[0];
        }
        int[] res = new int[A.length];
        int even = 0, odd = 1;
        for (int i = 0; i < A.length; i++) {
            // 都是偶数
            if ((A[i] & 1) == 0) {
                res[even] = A[i];
                even += 2;
            }
        }
        for (int i = 0; i < A.length; i++) {
            // 都是偶数
            if ((A[i] & 1) == 1) {
                res[odd] = A[i];
                odd += 2;
            }
        }
        return res;
    }
}
