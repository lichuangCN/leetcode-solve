package site.muzhi.leetcode.more;

/**
 * @author: lichuang
 * @date: 2020/03/21
 * @description: 裴蜀定理（或贝祖定理）
 * 说明了对任何整数a、b和它们的最大公约数d，
 * 关于未知数x和y的线性不定方程（称为裴蜀等式）：
 * 若a,b是整数,且gcd(a,b)=d，那么对于任意的整数x,y,ax+by都一定是d的倍数，
 * 特别地，一定存在整数x,y，使ax+by=d成立。
 */

public class $365_WaterAndJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return (z == 0) ? true : false;
        }
        return (z % gcd(x, y) == 0) ? true : false;
    }

    public int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
}
