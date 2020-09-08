package site.muzhi.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/09/08
 * @description 组合
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class $77_Combine {

    /**
     * 返回结果
     */
    List<List<Integer>> result;

    /**
     * 遍历的路径
     */
    LinkedList<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        track(n, k, 1);
        return result;
    }

    public void track(int n, int k, int startIndex) {
        if (path.size() == k) {
            // 满足个数要求
            List<Integer> p = new ArrayList<>(k);
            for (Integer integer : path) {
                p.add(integer);
            }
            result.add(p);
            return;
        }
        // 排列的时候i从1开始，组合的时候从上一层传来的startIndex开始
        // 当前题目是组合
        for (int i = startIndex; i <= n; i++) {
            // 处理当前节点
            path.addLast(i);
            track(n, k, i + 1);
            // 回溯,去掉当前节点
            path.removeLast();
        }
        // 下面是优化后的方案
        // 当后续的值不满足k个要求的时候，不进行后面的递归操作
        // 比如：n=4,k=3,当startIndex=3的时候,已经不满足k个值的要求,不进行后边的递归回溯
        // n-(k-path.size())+1 判断后续的值时候满足k条件
        //for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
        //    // 处理当前节点
        //    path.addLast(i);
        //    track(n, k, i + 1);
        //    // 回溯,去掉当前节点
        //    path.removeLast();
        //}
    }
}
