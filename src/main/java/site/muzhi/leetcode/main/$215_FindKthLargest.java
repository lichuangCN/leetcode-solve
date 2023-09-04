package site.muzhi.leetcode.main;

/**
 * Author: lichuang
 * Date: 2020/02/08
 * Description:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 算法思想：
 * 1.建立一个k大小的最小堆，堆顶元素是最小值
 * 2.遍历数组，当对顶元素小于数组中元素时，弹出对顶元素，数组中元素入堆顶，调整堆
 * 3.堆顶元素即是第k个大的元素。
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class $215_FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        // 先取前k个元素构建最小堆
        for (int i = 0; i < k; i++) {
            heap[i] = nums[i];
        }
        buildHeap(heap);

        for (int j = k; j < nums.length; j++) {
            if (heap[0] < nums[j]) {
                heap[0] = nums[j];
                buildHeap(heap);
            }
        }
        return heap[0];
    }

    /**
     * 建堆
     *
     * @param heap
     */
    public void buildHeap(int[] heap) {
        for (int i = heap.length / 2; i >= 0; i--) {
            heap(i, heap.length, heap);
        }
    }

    /**
     * 调整(最小)堆
     */
    public void heap(int i, int n, int[] heap) {
        // 左节点索引
        int l = i * 2 + 1;
        // 右节点索引
        int r = i * 2 + 2;
        // min 用来指三个节点中最小值的位置
        int min = i;
        if (l < n && heap[l] < heap[min]) {
            min = l;
        }
        if (r < n && heap[r] < heap[min]) {
            min = r;
        }
        // 父节点的值大于交换最小值
        if (min != i) {
            swap(i, min, heap);
            // 调整元素位置后，继续向下调整当前节点二叉树的堆
            heap(min, n, heap);
        }
    }

    /**
     * 交换
     *
     * @param x
     * @param y
     */
    public static void swap(int x, int y, int[] heap) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }
}
