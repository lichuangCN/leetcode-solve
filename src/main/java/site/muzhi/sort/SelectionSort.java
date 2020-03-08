package site.muzhi.sort;

import java.util.Arrays;

/**
 * Author: lichuang
 * Date: 2019/10/15
 * Description: 选择排序
 */

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 6, 1, 8, 2, 4, 9, 2};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int index = i;
            // 查询最小值的索引
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            // 存在小于处于当前坐标值的值,交换
            if (index != i) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
    }
}
