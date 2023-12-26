package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/12/25
 * 1276.不浪费原料的汉堡制作方案
 */
public class $1276_numOfBurgers {

    /*
     * 巨无霸汉堡 = x
     * 小皇堡 = y
     * 本题等价：
     * 1.证明以下二元一次方程组有正整数解
     * 2.返回正整数解
     *
     * 4x + 2y = tomatoSlices
     * x + y = cheeseSlices
     *
     * x = (tomatoSlices - 2*cheeseSlices)/2
     * y = cheeseSlices - (tomatoSlices - 2*cheeseSlices)/2
     */
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        boolean isX = (tomatoSlices - 2 * cheeseSlices) % 2 == 0;
        // 排除小数解
        if (!isX) {
            return new ArrayList<>(0);
        }
        int x = (tomatoSlices - 2 * cheeseSlices) / 2, y = cheeseSlices - (tomatoSlices - 2 * cheeseSlices) / 2;
        // 排除负数解
        if (x >= 0 && y >= 0) {
            return Arrays.asList(x, y);
        }
        return new ArrayList<>(0);
    }
}
