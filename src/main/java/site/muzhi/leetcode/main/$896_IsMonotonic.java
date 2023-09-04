package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/02/28
 * @description 单调数列
 */
public class $896_IsMonotonic {

    public boolean isMonotonic(int[] A) {
        boolean inc = false;
        boolean dec = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                inc = true;
            }
            if (A[i] < A[i - 1]) {
                dec = true;
            }
            if (inc && dec) {
                return false;
            }
        }
        return true;
    }
}
