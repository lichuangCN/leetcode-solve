package site.muzhi.interview;

/**
 * @author lichuang
 * @date 2021/03/01
 * @description 反转数位
 */
public class $05_03_ReverseBits {

    /**
     * curLen记录当前长度
     * preLen记录上次翻转后的长度
     *
     * @param num
     * @return
     */
    public int reverseBits(int num) {
        int maxLen = 0, preLen = 0, curLen = 0, bit = 32;
        while (bit-- > 0) {
            if ((num & 1) == 0) {
                curLen -= preLen;
                preLen = curLen + 1;
            }
            curLen++;
            maxLen = Math.max(maxLen, curLen);
            num >>= 1;
        }
        return maxLen;
    }
}
