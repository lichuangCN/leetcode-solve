package site.muzhi.sort;

import java.util.Arrays;

/**
 * Author: lichuang
 * Date: 2019/10/16
 * Description: 快速排序
 */

public class Quicksort {

    public static void main(String[] args) {
        int[] array = {6, 1, 3, 6, 1, 8, 2, 4, 9, 5};

        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int low, int high) {

        // 递归终止条件
        if (low >= high) {
            return;
        }
        int left = low, right = high;
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            // 右侧小于基数,交换
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                left++;
            }
            // 左侧大于基数,交换
            array[right] = array[left];
        }
        array[left] = temp;
        // 一次确定一个数的位置array[left]
        sort(array, low, left - 1);
        sort(array, left + 1, high);
    }
}
