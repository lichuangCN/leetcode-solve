package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/03/31
 * @description
 */
public class $08_10_FloodFill {


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void fill(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
            return;
        }
        if (image[r][c] == oldColor && image[r][c] != newColor) {
            image[r][c] = newColor;
            fill(image, r - 1, c, oldColor, newColor);
            fill(image, r, c + 1, oldColor, newColor);
            fill(image, r + 1, c, oldColor, newColor);
            fill(image, r, c - 1, oldColor, newColor);
        }
    }
}
