package site.muzhi.leetcode.string;

import java.util.*;

/**
 * @author lichuang
 * @date 2021/01/11
 * @description 交换字符串中的元素
 * <p>
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 */
public class $1202_SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 构建并查集
        int length = s.length();
        DisjointSetUnion dsu = new DisjointSetUnion(length);
        for (List<Integer> pair : pairs) {
            dsu.unionSet(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int parent = dsu.find(i);
            map.computeIfAbsent(parent, unused -> new ArrayList<Character>()).add(s.charAt(i));
        }
        // 根据字典序，逆序排列
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            Collections.sort(entry.getValue(), new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o2 - o1;
                }
            });
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int x = dsu.find(i);
            List<Character> list = map.get(x);
            // 每次弹出区间内最小的值，进行拼接
            builder.append(list.remove(list.size() - 1));
        }
        return builder.toString();
    }

    public class DisjointSetUnion {
        int[] parent; // 集合
        int[] rank;// 集合的秩
        int n;

        public DisjointSetUnion(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
            Arrays.fill(rank, 1);
            this.n = n;
        }

        public int find(int x) {
            // 如果自己还有父级，则继续去寻找自己的父级
            if (parent[x] != x) {
                // 并且在递归回溯的时候，将路径上的节点都指向自己的父级
                // 压缩寻找此节点的父节点的路径，简化后续的查询
                parent[x] = find(parent[x]);
            }
            // 自己就是根节点,返回
            return parent[x];
        }

        public void unionSet(int x, int y) {
            // 两个根节点
            int fx = find(x);
            int fy = find(y);
            // 如果同属于一个并查集，则不需要进行合并
            if (fx == fy) {
                return;
            }
            // 小集合向大集合中合并
            if (rank[fx] < rank[fy]) {
                parent[fx] = fy;
                rank[fx] += rank[fy];
            } else {
                parent[fy] = fx;
                rank[fy] += rank[fx];
            }
        }
    }
}
