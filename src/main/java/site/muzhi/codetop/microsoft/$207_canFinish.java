package site.muzhi.codetop.microsoft;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author lichuang
 * @date 2022/11/17
 * @description
 */
public class $207_canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0) {
            return false;
        }
        if (prerequisites.length == 0) {
            return true;
        }

        // 统计个节点的入度
        int[] inDegree = new int[numCourses];
        // 邻接表
        Set<Integer>[] adj = new HashSet[numCourses];
        // 邻接表初始化
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }


        for (int[] pre : prerequisites) {
            // 统计入度
            inDegree[pre[0]]++;
            // 邻接表赋值 保存一个节点的所有入度相关的节点
            adj[pre[1]].add(pre[0]);
        }

        // 所有入度 = 0的节点添加到队列
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Integer node = queue.poll();
            for (Integer i : adj[node]) {
                // 当前节点做移除操作 故相关节点的入度 -1
                inDegree[i]--;
                // 相关节点的入度 = 0 添加到队列
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return count == numCourses;
    }
}
