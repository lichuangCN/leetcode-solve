package site.muzhi.interview;

/**
 * @author lichuang
 * @date 2021/04/07
 * @description 面试题 10.03. 搜索旋转数组
 * <p>
 * https://leetcode-cn.com/problems/search-rotate-array-lcci/
 */
public class $10_03_Search {

    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[left] == target) {
                return left;
            }
            if (arr[mid] == target) {
                right = mid;
                continue;
            }
            if (arr[right] == target) {
                left = mid + 1;
                continue;
            }
            // 右侧递增
            if (arr[mid] < arr[right]) {
                if (arr[mid] < target && target < arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                continue;
            }
            // 左侧递增
            if (arr[mid] > arr[right]) {
                if (arr[left] < target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                continue;
            }
            // 什么情况都不满足
            right--;
        }

        return -1;
    }
}
