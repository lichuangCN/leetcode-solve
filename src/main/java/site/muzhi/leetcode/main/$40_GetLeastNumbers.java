package site.muzhi.leetcode.main;

import java.util.Arrays;

/**
 * @author: lichuang
 * @date: 2020/03/20
 * @description: 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 */

public class $40_GetLeastNumbers {

    /**
     * 通过构建一个k大小的最大堆，维护数组中k的最小的元素，
     * 堆顶元素即为第k小元素，堆中剩余元素均小于堆顶元素
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        int[] heap = new int[k];
        // 选用前k个元素作为初始堆
        for (int i = 0; i < k; i++) {
            heap[i] = arr[i];
        }
        for (int j = k / 2; j >= 0; j--) {
            adjustHeap(heap, j, k);
        }
        // 遍历剩下的元素
        for (int i = k; i < arr.length; i++) {
            // 如果小于堆顶元素，交换堆顶元素，并重新调整堆
            if (arr[i] < heap[0]) {
                heap[0] = arr[i];
                adjustHeap(heap, 0, k);
            }
        }
        return heap;
    }

    /**
     * 调整堆
     *
     * @param heap
     * @param i
     * @param size
     */
    public void adjustHeap(int[] heap, int i, int size) {
        // 节点i的左子节点
        int left = i * 2 + 1;
        // 节点i的右子节点
        int right = i * 2 + 2;
        int max = i;
        // 如果节点i的左子节点大
        if (left < size && heap[left] > heap[max]) {
            max = left;
        }
        // 如果节点i的右子节点大
        if (right < size && heap[right] > heap[max]) {
            max = right;
        }
        // 需要交换值
        if (max != i) {
            swap(heap, max, i);
            // 向下调整堆
            adjustHeap(heap, max, size);
        }
    }

    /**
     * 交换元素
     *
     * @param heap
     * @param x
     * @param y
     */
    public void swap(int[] heap, int x, int y) {
        int tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }

    //利用快排思想，每次只处理一个部分
    //具体思路：
    //当快排后的枢纽位置在k，恰好左边部分为要求的k+1个数
    //当枢纽位置小于k，前几个数字已经确定，需要确定后几个数字，令low = pivot + 1继续
    //当枢纽位置大于k，前k个数字在枢纽前，在枢纽前寻找数字，令high = pivot - 1继续
    //下面讨论low < high作为循环结束条件的合理性：
    //一般情况下，若k小于数组长度，low必然<=k，high必然>=k
    //由于pivot == k时直接结束循环不考虑，因此只有可能出现low == high == k
    //要使得上式成立，必然有两个状态满足pivot1==k-1和pivot2==k+1
    //pivot1前的部分必然是小于k的，而pivot2后的部分必然是大于k的
    //因此可以确定k是pivot1后数字中最小的一个，可以确定前k+1个数字已满足要求
    //特殊情况下，k等于数组长度。此时pivot < k始终成立，也就是pivot!=k
    //每趟处理后，必然有low = pivot + 1，也就是low必然会移动到满足low>=high
    //由于k等于数组长度，因此无论如何变动，取出的数组一定满足要求

    /**
     * @param arr
     * @param k
     * @return 返回当前已经确定值的位置
     */
    public int[] getLeastKNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int index = partation(arr, low, high);
            if (index < k) {
                low = index + 1;
            }
            if (index > k) {
                high = index - 1;
            }
            // 此时表明前k个元素已经是最小的k个元素
            if (index == k) {
                break;
            }
        }
        return Arrays.copyOf(arr, k);
    }

    /**
     * 快排操作
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    public int partation(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] > pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        // 返回当前标志位的位置
        return low;
    }
}
