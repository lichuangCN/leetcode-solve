package site.muzhi.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author lichuang
 * @date 2020/11/06
 * @description 根据数字二进制下 1 的数目排序
 */
public class $1356_SortByBits {

    /**
     * 计算每个值的1的个数
     *
     * @param arr
     * @return
     */
    public int[] sortByBits(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>(arr.length);
        int[] bitArr = new int[100001];
        for (int n : arr) {
            list.add(n);
            bitArr[n] = get(n);
        }
        // 排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (bitArr[x] != bitArr[y]) {
                    // 两个值中1出现的次数不同，递增
                    return bitArr[x] - bitArr[y];
                } else {
                    // 两个值相同，根据值大小递增
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * 统计数字n中1的个数
     *
     * @param n
     * @return
     */
    private int get(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }

    /**
     * 数字中1的个数预处理
     *
     * @param arr
     * @return
     */
    public int[] sortByBits2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        // 预处理
        int[] bitArr = new int[10001];
        for (int i = 1; i < 10001; i++) {
            bitArr[i] = bitArr[i >> 1] + (i & 1);
        }
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i : arr) {
            list.add(i);
        }
        // 比较
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (bitArr[x] != bitArr[y]) {
                    return bitArr[x] - bitArr[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
