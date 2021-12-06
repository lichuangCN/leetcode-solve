package site.muzhi.leetcode.interview;

/**
 * @author lichuang
 * @date 2021/03/03
 * @description 下一个数
 */
public class $05_04_FindClosedNumbers {

    public int[] findClosedNumbers(int num) {
        int numCount = bitCount(num);

        int[] res = new int[2];
        res[0] = res[1] = -1;
        if (num == Integer.MAX_VALUE) {
            return res;
        }
        // 找
        for (int i = num + 1; i < Integer.MAX_VALUE; i++) {
            int bitCount = bitCount(i);
            if (bitCount == numCount) {
                res[0] = i;
                break;
            }
        }

        for (int i = num - 1; i >= 1; i++) {
            int bitCount = bitCount(i);
            if (bitCount == numCount) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public int bitCount(int num) {
        int bitCount = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                bitCount++;
            }
            num >>= 1;
        }
        return bitCount;
    }
}
