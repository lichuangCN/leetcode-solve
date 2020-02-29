package site.muzhi.sort;

/**
 * @author: LiChuang
 * @date: 2020/02/29
 * @description: 堆排序，构建最小堆，降序
 */
public class HeapSortMin {

    /**
     * 排序全部元素
     *
     * @param heap
     */
    public void sort(int[] heap) {
        // 构建最小堆
        buildHeap(heap, heap.length);
        // 循环交换最后一个元素和第一个元素，不断调整堆
        for (int index = heap.length - 1; index > 0; index--) {
            swap(heap, 0, index);
            adjust(heap, 0, index);
        }

    }

    /**
     * 指定长度范围内进行排序
     *
     * @param heap
     * @param length
     */
    public void sort(int[] heap, int length) {
        // 构建最小堆
        buildHeap(heap, length);
        // 循环交换最后一个元素和第一个元素，不断调整堆
        for (int index = length - 1; index > 0; index--) {
            swap(heap, 0, index);
            adjust(heap, 0, index);
        }
    }

    /**
     * 1.建堆(最小堆)
     *
     * @param heap
     * @param heapSize
     */
    public void buildHeap(int[] heap, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            adjust(heap, i, heapSize);
        }
    }

    /**
     * 2.调整以i为根节点的堆
     *
     * @param heap
     * @param i
     * @param n
     */
    private void adjust(int[] heap, int i, int n) {
        // 因为是以数组为载体，所以左右两个子节点分别为+1，+2
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        // 最大值位置
        int min = i;
        if (left < n && heap[min] > heap[left]) {
            min = left;
        }
        if (right < n && heap[min] > heap[right]) {
            min = right;
        }
        // 当前节点大于其子节点的值
        if (min != i) {
            // 调整最小值为当前根节点的堆顶元素
            swap(heap, i, min);
            // 继续向下调整堆
            adjust(heap, min, n);
        }
    }

    /**
     * 交换两个值
     *
     * @param x
     * @param y
     */
    private void swap(int[] heap, int x, int y) {
        int tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }
}
