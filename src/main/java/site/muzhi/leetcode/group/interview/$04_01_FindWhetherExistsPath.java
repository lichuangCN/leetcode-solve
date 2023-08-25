package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/02/20
 * @description
 */
public class $04_01_FindWhetherExistsPath {

    // 记录当前路径是否被使用
    boolean[] visited = null;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (visited == null) {
            visited = new boolean[graph.length];
        }
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (graph[i][0] == start && graph[i][1] == target) {
                    return true;
                }
                visited[i] = true;
                // 目标点倒序寻找
                if (graph[i][1] == target && findWhetherExistsPath(n, graph, start, graph[i][0])) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
