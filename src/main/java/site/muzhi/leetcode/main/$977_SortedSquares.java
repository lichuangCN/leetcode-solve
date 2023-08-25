package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2020/10/16
 * @description 有序数组的平方
 * <p>
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class $977_SortedSquares {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int r = A[i] * A[i];
            // 寻找应该插入的位置，并移动元素
            // 本质是插入排序
            int index = A.length - 1;
            while (r <= res[index] && index > 0) {
                index--;
            }
            // 移动前面的元素 [A.length-i,index]
            int j = A.length - i;
            while (j <= index) {
                res[j - 1] = res[j];
                j++;
            }
            res[index] = r;
        }
        return res;
    }

    /**
     * 双指针
     *
     * @param A
     * @return
     */
    public int[] sortedSquares2(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int[] res = new int[A.length];
        int left = 0, right = A.length - 1, ptr = A.length - 1;
        // 双指针，从左右两侧开始，比较两个指针指向的结果的最大值
        // 将最大的那个值放入到唯一确定的位置 ptr 上
        while (left <= right) {
            int leftVal = A[left] * A[left];
            int rightVal = A[right] * A[right];
            if (leftVal > rightVal) {
                res[ptr] = leftVal;
                left++;
            } else {
                res[ptr] = rightVal;
                right--;
            }
            ptr--;
        }
        return res;
    }
}
