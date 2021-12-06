package site.muzhi.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/01/20
 * @description
 */
public class $1584_MinCostConnectPoints {

    /**
     * Kruskal 最小生成树
     *
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        DisjointSetUnion dsu = new DisjointSetUnion(length);
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                edgeList.add(new Edge(dist(points, i, j), i, j));
            }
        }
        // 排序正序
        Collections.sort(edgeList, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len - o2.len;
            }
        });

        // Kruskal
        int num = 0, ret = 0;
        for (Edge edge : edgeList) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (dsu.union(x, y)) {
                ret += len;
                num++;
            }
            // 已经达到最小边(n个节点只需要n-1条边)
            if (num == length - 1) {
                break;
            }
        }
        return ret;
    }

    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    public class Edge {
        int len;
        // x,y分别表示points中的点的索引位置
        int x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }

    public class DisjointSetUnion {
        int[] parent;
        int[] rank;

        public DisjointSetUnion(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * @param x
         * @param y
         * @return false表示当前两个点已经是连通的，true表示当前连通图中新加入节点
         */
        public boolean union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) {
                return false;
            }
            if (rank[fx] < rank[fy]) {
                parent[fx] = fy;
                rank[fy] += rank[fx];
            } else {
                parent[fy] = fx;
                rank[fx] += rank[fy];
            }
            return true;
        }
    }
}
