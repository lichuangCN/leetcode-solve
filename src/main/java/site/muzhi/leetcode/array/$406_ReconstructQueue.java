package site.muzhi.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2020/11/16
 * @description 根据身高重建队列
 */
public class $406_ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        // 1.先对身高进行降序排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if (x[0] == y[0]) {
                    return x[1] - y[1];
                } else {
                    return y[0] - x[0];
                }
            }
        });

        LinkedList<int[]> list = new LinkedList<>();
        // 2.根据身高和前面人数找自己位置
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][2]);
    }
}
