package site.muzhi.basesort;

/**
 * Author: lichuang
 * Date: 2019/9/19
 * Description: 冒泡排序
 * 优化：
 * 1、减少一趟排序中的比较次数；
 * 2、减少总体的排序次数，当集合有序时停止排序
 */

public class BubbleSort {

    public void sort(int[] array) {
        // 判断一趟排序中是否发生交换
        boolean change = false;

        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    // 发生交换
                    change = true;
                }
            }
            // 没有交换，终止排序
            if (!change) {
                break;
            }
            change = false;
        }
    }
}
