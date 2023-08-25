package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2020/11/03
 * @description 有效的山脉数组
 */
public class $941_ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int left = 0, right = A.length - 1;
        // 从左侧寻找山峰
        while (left + 1 <= A.length - 1 && A[left + 1] > A[left]) {
            left++;
        }
        // 从右侧寻找山峰
        while (right - 1 >= 0 && A[right - 1] > A[right]) {
            right--;
        }
        // 是否是同一个山峰
        return (right == left) && (right > 0) && (left < A.length - 1);
    }
}
