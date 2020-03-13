package site.muzhi.array;

/**
 * @author: lichuang
 * @date: 2020/03/13
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */

public class $62_UniquePaths {

    /**
     * 根据要求，到达第[i][j]位置只有从[i-1][j]和[i][j-1]两个位置
     * 因此需要当到达第[i][j]位置时，只要将到达上面两个位置的路径数累加就是从开始到达此位置的路径数
     * [注]要先处理第一行和第一列的值，因为只能向右或向下移动，这些位置的路径数只能是1
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 处理第一行和第一列的值为1，表示到达此位置只有一种路径
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 处理剩余位置
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 根据要求，到达第[i][j]位置只有从[i-1][j]和[i][j-1]两个位置
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
