package site.muzhi.array;

/**
 * @author lichuang
 * @date 2021/02/19
 * @description 最大连续1的个数 III
 */
public class $1004_LongestOnes {

    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, max = 0, count = 0;
        while (right < A.length) {
            if (A[right] == 0) {
                count++;
            }
            while (count > K) {
                if (A[left] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
