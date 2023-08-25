package site.muzhi.leetcode.array;

/**
 * @author: lichuang
 * @date: 2020/03/18
 * @description: 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 */

public class $223_RectangleOverlap2 {

    /**
     * 采用投影办法计算重叠矩形的坐标，计算重叠面积
     * 两个矩形总面积-重叠面积
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // 投影到x轴
        int X1 = Math.max(A, E);
        int X2 = Math.min(C, G);
        // 投影到y轴
        int Y1 = Math.max(B, F);
        int Y2 = Math.min(D, H);

        // 两个矩形的面积
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        // 如果存在重叠部分
        if (X1 < X2 && Y1 < Y2) {
            return area1 + area2 - (X2 - X1) * (Y2 - Y1);
        }
        // 不存在重叠
        return area1 + area2;
    }
}
