package site.muzhi.sort;

import java.util.Arrays;

/**
 * Author: lichuang
 * Date: 2019/10/17
 * Description: 希尔排序,简单插入排序的改进型
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列
 * 中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 * 1.  选择一个增量序列 t1，t2，…，tk，其中 ti>tj，tk=1；
 * 2.  按增量序列个数 k，对序列进行 k 趟排序；
 * 3.  每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进
 * 行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长
 * 度
 */

public class ShellSort {

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 4, 1, 8, 2, 4, 9, 2};
        int dk = array.length / 2;
        while (dk > 0) {
            sort(array, dk);
            dk /= 2;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int dk) {
        for (int i = dk; i < array.length; i++) {
            // 插入
            if (array[i] < array[i - dk]) {
                // 要插入的元素
                int temp = array[i];
                // 元素后移
                int index = i - dk;
                while (index >= 0 && array[index] > temp) {
                    array[index + dk] = array[index];
                    index -= dk;
                }
                array[index + dk] = temp;
            }
        }
    }
}
