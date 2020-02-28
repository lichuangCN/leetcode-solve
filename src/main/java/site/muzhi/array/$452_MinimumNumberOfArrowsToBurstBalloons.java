package site.muzhi.array;

import java.util.Arrays;

/**
 * @author: LiChuang
 * @date: 2020/02/24
 * @description: 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。
 * 开始坐标总是小于结束坐标。平面内最多存在104个气球。
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。
 * 在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。
 * 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * Example:
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 * 输出:
 * 2
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 */
public class $452_MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 排序，左端点从小到大排序
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        // 射击次数
        int shotNum = 1;
        // 射击的公共区间
        int start = points[0][0];
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // 判断当前区间与公共区间是否存在交集
            if (points[i][0] <= end) {
                // 修改公共区间左端点
                start = points[i][0];
                if (points[i][1] < end) {
                    // 修改公共区间右端点
                    end = points[i][1];
                }
            } else {
                // 不存在公共区间,需要重新维护一个射击的公共区间
                shotNum++;
                start = points[i][0];
                end = points[i][1];
            }
        }
        return shotNum;
    }
}
