package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2021/04/22
 * @description 363. 矩形区域不超过 K 的最大数值和
 * <p>
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class $363_MaxSumSubmatrix {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;

        int[][] sum = new int[row + 1][col + 1];

        // 前缀和，预处理
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                // sum[i-1][j]和sum[i][j-1]中都计算了一次sum[i-1][j-1]，因此需要减去一次
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                for (int p = i; p <= row; p++) {
                    for (int q = j; q <= col; q++) {
                        // ?
                        int curr = sum[p][q] - sum[p][j - 1] - sum[i - 1][q] + sum[i - 1][j - 1];
                        if (curr <= k) {
                            res = Math.max(res, curr);
                        }
                    }
                }
            }
        }

        return res;
    }
}
