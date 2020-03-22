package site.muzhi.array;

import java.util.Arrays;

/**
 * @author: lichuang
 * @date: 2020/03/22
 * @description: 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * <p>
 * 示例 1:
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 */

public class $945_MinimumIncrementToMakeArrayUnique {

    /**
     * 思想：
     * 1、对数组进行排序；
     * 2、
     * 2.1 如果A[i]==A[i-1]， 则重复个数+1，并且记录操作次数的值减去A[i]
     * 2.2 如果A[i]>A[i-1]，比较两个元素之间的间隔和重复个数，取最小值len，
     * 即将将len个重复元素累加到这个区间(A[i-1],A[i])
     * 2.3 操作次数加上这个区间(A[i-1],A[i])的所有值
     * 3、如果还存在重复数，则将这些重复数全部累加到当前最大值的后面
     *
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }

        Arrays.sort(A);
        // count: 重复元素的个数，result:操作次数
        int count = 0, result = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                count++;
                /*
                 * 此处涉及本思想的一个优化点: target：A[i]要累加到的值
                 * result+(target-A[i]) = result-A[i]+target
                 */
                result -= A[i];
            } else {
                // A[i]>A[i-1]
                // A[i]和A[i-1]之间间隔的长度与目前重复元素的个数进行匹配，取最小值
                int len = Math.min(count, A[i] - A[i - 1] - 1);
                // 计算填补这些间隔需要进行的操作数,
                // 如果说A[i]和A[i-1]之间的间隔大于重复元素，其实只使用重复元素个位置就足够
                result += (A[i - 1] + 1 + A[i - 1] + len) * len / 2;
                // 减去填补这些间隔的重复元素
                count -= len;
            }
        }
        // 仍存在重复元素没能够消除，全部累加到A[A.length]元素后面
        if (count > 0) {
            int elem = A[A.length - 1];
            for (int i = 1; i <= count; i++) {
                result += (elem + i);
            }
        }
        return result;
    }
}
