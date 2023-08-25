package site.muzhi.leetcode.array;

import java.util.LinkedList;

/**
 * @author: LiChuang
 * @date: 2020/03/04
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1
 */
public class $994_RottingOranges {

    /**
     * 腐烂的橘子的位置和腐烂的时间
     */
    class Pos {
        // 当前橘子的位置和第几分钟腐烂；
        int x, y, minute;

        public Pos(int x, int y, int minute) {
            this.x = x;
            this.y = y;
            this.minute = minute;
        }
    }

    /**
     * 1.找出所有新鲜橘子的个数和已经腐烂的橘子的位置
     * 2.每一轮遍历上一轮被腐烂的橘子，并将新腐烂的橘子加入腐烂的橘子队列
     * 3.若所有橘子都已经腐烂，则队列中的元素时最后一轮腐烂的橘子信息，包括腐烂的时间
     * 4.如果存在新鲜的橘子，则返回-1
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        // 新鲜橘子数目
        int freshs = 0;
        LinkedList<Pos> queue = new LinkedList<>();
        // 遍历数组，检索出腐烂橘子的位置和统计新鲜橘子的个数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 当前橘子是新鲜橘子
                if (grid[i][j] == 1) {
                    freshs++;
                }
                // 当前橘子是腐烂橘子
                if (grid[i][j] == 2) {
                    queue.offer(new Pos(i, j, 0));
                }
            }
        }
        // 如果不存在新鲜橘子
        if (freshs == 0) {
            return 0;
        }
        // 如果不存在腐烂的橘子
        if (queue.isEmpty()) {
            return -1;
        }
        // 橘子开始腐烂，一层一层向外腐烂
        while (!queue.isEmpty() && freshs > 0) {
            // 处理当前层的腐烂橘子
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pos pos = queue.poll();
                // 处理当前腐烂橘子节点的四个正方向上的橘子
                // 当前橘子的位置[x][y]
                int x = pos.x, y = pos.y;
                // 当前橘子的腐烂时间
                int minute = pos.minute;
                // 处理正上方，正上方存在橘子并且是新鲜的橘子
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    // 当前橘子腐烂
                    grid[x][y - 1] = 2;
                    // 将新腐烂的橘子加入队列
                    queue.offer(new Pos(x, y - 1, minute + 1));
                    freshs--;
                }
                // 处理正右方，如果正右方存在橘子并且是新鲜橘子
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    queue.offer(new Pos(x + 1, y, minute + 1));
                    freshs--;
                }
                // 处理正下方
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    queue.offer(new Pos(x, y + 1, minute + 1));
                    freshs--;
                }
                // 处理正左方
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    queue.offer(new Pos(x - 1, y, minute + 1));
                    freshs--;
                }
            }
        }
        // 如果所有橘子都腐烂
        if (freshs == 0) {
            // 此时队列中的橘子是最后一批腐烂的橘子
            return queue.peek().minute;
        }
        // 存在新鲜的橘子
        return -1;
    }
}
