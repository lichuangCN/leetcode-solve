package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2020/09/27
 * @description 二进制中1的个数
 */
public class $15_HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            // 无符号右移，高位插0
            n >>>= 1;
        }
        return count;
    }
}
