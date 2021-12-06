package site.muzhi.leetcode.interview;

/**
 * @author: LiChuang
 * @date: 2020/03/03
 * @description: 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class $10_01_SortedMergeLcci {

    /**
     * 从后向前插入，每次确定一个最大元素位置
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {

        // 插入数组A的位置的下标索引
        int index = m + n - 1;
        // 当A和B中均还有元素
        while (m > 0 && n > 0) {
            A[index--] = (A[m - 1] >= B[n - 1]) ? A[--m] : B[--n];
        }
        // 数组B中仍还有元素，一并添加到数组A
        while (n > 0) {
            A[index--] = B[--n];
        }
    }

    /**
     * 新创建数组空间，由前向后插入，每次确定一个最小位置
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        int[] result = new int[m + n];
        int index = 0, iA = 0, iB = 0;
        while (iA < m && iB < n) {
            result[index++] = (A[iA] < B[iB]) ? A[iA++] : B[iB++];
        }
        while (iA < m) {
            result[index++] = A[iA++];
        }
        while (iB < n) {
            result[index++] = B[iB++];
        }
    }
}
