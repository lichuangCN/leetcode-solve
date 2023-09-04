package site.muzhi.leetcode.main;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/01/23
 * @description 数组形式的整数加法
 */
public class $989_AddToArrayForm {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int length = A.length;
        int lastNum = K;

        LinkedList<Integer> list = new LinkedList<Integer>();

        // 倒着遍历，正着插入
        int idx = length - 1;
        while (idx >= 0 || lastNum > 0) {
            // 如果数组中还存在元素
            if (idx >= 0) {
                lastNum += A[idx];
            }
            list.addFirst(lastNum % 10);
            lastNum /= 10;
            idx--;
        }
        return list;
    }
}
