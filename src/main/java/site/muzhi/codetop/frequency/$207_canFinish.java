package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author lichuang
 * @date 2024/01/22
 * 207.课程表
 */
public class $207_canFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0) {
            return false;
        }
        if (prerequisites.length == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        Set<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] site : prerequisites) {
            inDegree[site[0]]++;
            adj[site[1]].add(site[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int finish = 0;
        while (!queue.isEmpty()) {
            finish++;
            Integer course = queue.poll();
            for (Integer next : adj[course]) {
                inDegree[next] -= 1;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return finish == numCourses;
    }
}
