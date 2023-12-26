package site.muzhi.leetcode.main;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/12/25
 * 毯子覆盖的最多白色转快熟2
 */
public class $2271_maximumWhiteTiles {

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (x, y) -> x[0] - y[0]);
        // left 毯子覆盖的最左侧地砖块
        // right 毯子能覆盖的最右侧地砖块
        // ans 窗口移动过程中覆盖的最大值
        // curr 当前窗口所遮盖的地砖块
        int left = 0, right = 0, len = tiles.length, ans = 0, curr = 0;
        while (left <= right && right < len) {
            // 找到毯子最后可能覆盖到的地砖区域 right
            while (right < len && tiles[right][1] - tiles[left][0] + 1 <= carpetLen) {
                curr = curr + (tiles[right][1] - tiles[right][0] + 1);
                right++;
            }
            // case 1. right = len 即已经覆盖所有区域段

            // case 2. right < len && tiles[right][1] - tiles[left][0] + 1 > carpetLen
            // case 2.1.right区域一部分在窗口内
            // tiles[left][0] + carpetLen - 1 >= tiles[right][0]

            // case 2.2.right区域均不再窗口内
            // tiles[left][0] + carpetLen - 1 < tiles[right][0]
            if (right == len) {
                //  case 1.毯子完全覆盖所在区域的地砖
                ans = Math.max(ans, curr);
            } else {
                // more 计算 right区间占用的地板数
                int more = 0;
                if (tiles[left][0] + carpetLen - 1 >= tiles[right][0]) {
                    // case 2.1.right区域一部分在窗口内
                    more = tiles[left][0] + carpetLen - tiles[right][0];
                } else {
                    // case 2.2.right区域均不再窗口内
                    more = 0;
                }
                // 省流版：如果是case 2.2, tiles[left][0] + carpetLen - tiles[right][0]计算值是负数值
                // int more = Math.max(0, tiles[left][0] + carpetLen - tiles[right][0]);
                ans = Math.max(ans, curr + more);
            }
            // 窗口移动到下一块区域，并移除上一区域的覆盖值
            curr = curr - (tiles[left][1] - tiles[left][0] + 1);
            left++;
        }
        return ans;
    }
}
