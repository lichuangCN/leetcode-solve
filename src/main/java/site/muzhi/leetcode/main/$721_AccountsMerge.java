package site.muzhi.leetcode.main;

import java.util.*;

/**
 * @author lichuang
 * @date 2021/01/18
 * @description
 */
public class $721_AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return new ArrayList<>(0);
        }

        HashMap<String, Integer> emailToIndexMap = new HashMap<>();
        HashMap<String, String> emailToNameMap = new HashMap<>();
        int emailCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndexMap.containsKey(email)) {
                    emailToIndexMap.put(email, emailCount++);
                    emailToNameMap.put(email, name);
                }
            }
        }

        DisjointSetUnion dsu = new DisjointSetUnion(emailCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                Integer firstIndex = emailToIndexMap.get(firstEmail);
                Integer nextIndex = emailToIndexMap.get(nextEmail);
                dsu.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmailMap = new HashMap<>();
        for (String email : emailToIndexMap.keySet()) {
            Integer emailIndex = emailToIndexMap.get(email);
            int parentIndex = dsu.find(emailIndex);
            List<String> list = indexToEmailMap.getOrDefault(parentIndex, new ArrayList<>());
            list.add(email);
            indexToEmailMap.put(parentIndex, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : indexToEmailMap.entrySet()) {
            List<String> list = entry.getValue();
            Collections.sort(list);
            String email = list.get(0);
            String name = emailToNameMap.get(email);
            List<String> r = new ArrayList<>(list.size() + 1);
            r.add(name);
            r.addAll(list);
            result.add(r);
        }
        return result;
    }

    public class DisjointSetUnion {
        int[] parent;
        int[] rank;

        public DisjointSetUnion(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            Arrays.fill(rank, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) {
                return;
            }

            if (rank[fx] < rank[fy]) {
                parent[fx] = fy;
                rank[fy] += rank[fx];
            } else {
                parent[fy] = fx;
                rank[fx] += rank[fy];
            }
        }
    }

}
