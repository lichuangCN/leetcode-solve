package site.muzhi.leetcode.cla.interview.chapter3;

/**
 * @author lichuang
 * @date 2021/04/13
 * @description 数组中的第K个最大元素
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xal9h6/
 */
public class $2_findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = nums[i];
        }
        buildHeap(heap);
        for (int i = k; i < nums.length; i++) {
            if (heap[0] < nums[i]) {
                heap[0] = nums[i];
                buildHeap(heap);
            }
        }
        return heap[0];
    }

    /*
     * 1、建堆
     * 2、调整堆
     */
    private void buildHeap(int[] heap) {
        for (int i = heap.length / 2; i >= 0; i--) {
            heap(heap, i, heap.length);
        }
    }

    private void heap(int[] heap, int i, int n) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        int min = i;
        if (l < n && heap[l] < heap[min]) {
            min = l;
        }
        if (r < n && heap[r] < heap[min]) {
            min = r;
        }
        if (min != i) {
            swap(heap, i, min);
            heap(heap, min, n);
        }
    }

    private void swap(int heap[], int x, int y) {
        int t = heap[x];
        heap[x] = heap[y];
        heap[y] = t;
    }

}
