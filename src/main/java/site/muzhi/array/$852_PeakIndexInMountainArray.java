package site.muzhi.array;

/**
 * @author lichuang
 * @date 2021/06/15
 * @description
 */
public class $852_PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
