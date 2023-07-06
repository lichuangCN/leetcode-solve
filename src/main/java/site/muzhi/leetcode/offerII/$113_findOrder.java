package site.muzhi.leetcode.offerII;

import java.util.*;

/**
 * @author lichuang
 * @date 2023/07/06
 * 113.课程顺序（图论 有序拓扑图）
 */
public class $113_findOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 入度
        int[] inDegree = new int[numCourses];
        // 后继节点集合
        Map<Integer, List<Integer>> nextMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;
            List<Integer> next = nextMap.getOrDefault(pre[1], new ArrayList<>());
            next.add(pre[0]);
            nextMap.put(pre[1], next);
        }

        // 统计入度为0的节点
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            ans[idx++] = course;
            // 后继节点：入度-1; 如果入度==0,加入队列
            // getOrDefault() 最后一门课，没有后继节点
            for (Integer next : nextMap.getOrDefault(course, new ArrayList<>())) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        // 课程排满
        if (idx == numCourses) {
            return ans;
        }
        return new int[0];
    }
}
