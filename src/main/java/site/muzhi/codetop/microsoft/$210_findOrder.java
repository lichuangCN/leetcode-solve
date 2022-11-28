package site.muzhi.codetop.microsoft;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author lichuang
 * @date 2022/11/28
 * @description 210. 课程表 II
 * <p>
 * https://leetcode.cn/problems/course-schedule-ii/
 */
public class $210_findOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 0) {
            return new int[0];
        }

        int[] inDegree = new int[numCourses];
        Set<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // 初始化入度和后继节点
        for (int[] pre : prerequisites) {
            // 统计入度
            inDegree[pre[0]]++;
            // 后继节点集合
            adj[pre[1]].add(pre[0]);
        }

        // 统计所有入度 = 0的节点
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] ans = new int[numCourses];
        // 已经学习完成的课程数
        int count = 0;
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            // 学完的课程加入结果
            ans[count++] = curr;
            for (Integer i : adj[curr]) {
                inDegree[i]--;
                // 前置课程已经学完的节点加入队列
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        if (count == numCourses) {
            return ans;
        }
        return new int[0];
    }
}
