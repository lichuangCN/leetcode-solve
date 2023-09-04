package site.muzhi.leetcode.main;

/**
 * @author: lichuang
 * @date: 2020/03/18
 * @description: 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，
 * (x2, y2) 是右上角的坐标。如果相交的面积为正，则称两矩形重叠。
 * 需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 给出两个矩形，判断它们是否重叠并返回结果。
 * <p>
 * 示例 1：
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 */

public class $836_RectangleOverlap1 {

    /**
     * 在平面中放置一个固定的矩形 rec2，
     * 那么矩形 rec1 必须要出现在 rec2 的「四周」:
     * 矩形 rec1 在矩形 rec2 的左侧；
     * 矩形 rec1 在矩形 rec2 的右侧；
     * 矩形 rec1 在矩形 rec2 的上方；
     * 矩形 rec1 在矩形 rec2 的下方
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        return !(
                // r1在r2上方
                rec1[1] >= rec2[3]
                        // r1在r2右侧
                        || rec1[0] >= rec2[2]
                        // r1在r2下方
                        || rec1[3] <= rec2[1]
                        // r1在r2左侧
                        || rec1[2] <= rec2[0]
        );
    }

    /**
     * 采用投影的方式，如果说两个矩形之间有重叠，
     * 那么它们在x和y轴两个方向的投影可以组成一个矩形
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        return (
                // 投影到x轴
                Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                        // 投影到y轴
                        Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1])
        );
    }
}
