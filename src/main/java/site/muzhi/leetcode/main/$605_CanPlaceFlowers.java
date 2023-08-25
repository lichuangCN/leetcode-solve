package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2021/01/04
 * @description 种花问题
 */
public class $605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0 || n < 0) {
            return false;
        }
        int idx, len;
        for (idx = 0; idx < (len = flowerbed.length); ) {
            if (flowerbed[idx] == 1) {
                idx += 2;
            } else if (idx == len - 1 || flowerbed[idx + 1] == 0) {
                n--;
                flowerbed[idx] = 1;
                idx += 2;
            } else {
                idx += 3;
            }
        }
        return n <= 0;
    }
}
