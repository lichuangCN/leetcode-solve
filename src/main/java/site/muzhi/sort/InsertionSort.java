package site.muzhi.sort;

import java.util.Arrays;

/**
 * Author: lichuang
 * Date: 2019/10/15
 * Description: 简单插入排序
 */

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 6, 1, 8, 2, 4, 9, 2};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            // 不发生交换
            if (array[i] > array[i - 1]) {
                continue;
            }
            // 发生交换
            int temp = array[i];
            // 被插入的位置
            int index = i - 1;
            // 比较是否小于当前i处的值或是比较到第一个
            while (temp < array[index] && index > 0) {
                // 将前面的数据向后移动
                array[index + 1] = array[index];
                // 将游标向前移动
                index--;
            }
            // 插入到合适位置
            array[index] = temp;
        }
    }
}
