package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/06/08
 * 69.山峰数组的顶部
 */
public class $69_peakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        // left == right 可能满足条件，此时会陷入死循环，故此处判断 left < right
        while (left < right) {
            int mid = (left + right) / 2;
            // 比较左右两侧
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
