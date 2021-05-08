package site.muzhi.basesort;

import java.util.Arrays;

/**
 * Author: lichuang
 * Date: 2019/10/17
 * Description: 归并排序(二路归并)
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 6, 1, 8, 2, 4, 9, 2};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 二路归并
     *
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {

        // 停止递归条件
        if (left >= right) {
            return;
        }

        //int center = (left + right) / 2; 避免left+right超出整型范围
        int center = left + (right - left) / 2;
        // 递归左侧
        sort(array, left, center);
        // 递归右侧
        sort(array, center + 1, right);

        // 合并
        merge(array, left, center, right);
    }


    /**
     * 合并两段数组
     *
     * @param array  数组
     * @param left   左侧数组第一个元素下标
     * @param center 左侧数组最后一个元素下标,右侧第一个元素下边为center+1
     * @param right  右侧最后一个元素下标
     */
    public static void merge(int[] array, int left, int center, int right) {

        // 创建临时数组
        int[] temp = new int[array.length];
        // 临时数组的索引
        int tempIndex = left;
        // 左侧数组的索引
        int leftIndex = left;
        // 右侧数组的索引
        int rightIndex = center + 1;
        // 向临时数组填充数据(填充后此部分数据是有序的)
        while (leftIndex <= center && rightIndex <= right) {
            if (array[leftIndex] < array[rightIndex]) {
                // 左侧数组元素小于右侧元素时
                temp[tempIndex++] = array[leftIndex++];
            } else {
                // 左侧数组元素大于右侧元素时
                temp[tempIndex++] = array[rightIndex++];
            }
        }
        // 剩余元素填充
        while (leftIndex <= center) {
            // 左侧数组剩余
            temp[tempIndex++] = array[leftIndex++];
        }
        while (rightIndex <= right) {
            // 右侧数组剩余
            temp[tempIndex++] = array[rightIndex++];
        }

        // 将临时数组的数据复制到原数据数组中
        // [left,right]
        while (left <= right) {
            array[left] = temp[left];
            left++;
        }
    }

}
