package site.muzhi.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2021/01/15
 * @description 移除最多的同行或同列石头
 */
public class $947_RemoveStones {

    public int removeStones(int[][] stones) {
        DisjointSetUnion dsu = new DisjointSetUnion();
        for (int[] stone : stones) {
            dsu.union(stone[0] + 10001, stone[1]);
        }

        return stones.length - dsu.numberOfConnectedComponent();
    }

    class DisjointSetUnion {

        // <val,parent[节点值][秩]>
        private Map<Integer, int[]> parent;
        private int connectCount;

        DisjointSetUnion() {
            parent = new HashMap<>();
            connectCount = 0;
        }

        int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, new int[]{x, 1});
                connectCount++;
            }
            int[] val = parent.get(x);
            if (val[0] != x) {
                val[0] = find(val[0]);
                parent.put(x, val);
            }
            return parent.get(x)[0];
        }

        void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) {
                return;
            }
            int[] fxVal = parent.get(fx);
            int[] fyVal = parent.get(fy);
            if (fxVal[1] < fyVal[1]) {
                fxVal[0] = fy;
                fyVal[1] += fxVal[1];
            } else {
                fyVal[0] = fx;
                fxVal[1] += fyVal[1];
            }
            connectCount--;
        }

        public int numberOfConnectedComponent() {
            return connectCount;
        }
    }
}