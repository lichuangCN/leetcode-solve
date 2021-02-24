package site.muzhi.array;

/**
 * @author lichuang
 * @date 2021/02/24
 * @description
 */
public class $832_FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {
        int r = A.length, c = A[0].length;
        for (int i = 0; i < r; i++) {
            int m = 0, n = c - 1;
            while (m < n) {
                int t = A[i][n] ^ 1;
                A[i][n] = A[i][m] ^ 1;
                A[i][m] = t;
                m++;
                n--;
            }
            if (m == n) {
                A[i][m] ^= 1;
            }
        }
        return A;
    }
}
