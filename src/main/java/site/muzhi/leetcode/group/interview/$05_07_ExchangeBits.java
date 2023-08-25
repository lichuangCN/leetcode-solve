package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/03/05
 * @description 配对交换
 */
public class $05_07_ExchangeBits {
    public int exchangeBits(int num) {
        //0xaaaaaaaa = 10101010101010101010101010101010
        //0x55555555 = 01010101010101010101010101010101
        //把num的偶数位值提取出来
        int even = num & 0x55555555;
        //把num的奇数位值提取出来
        int odd = num & 0xaaaaaaaa;
        //偶数位值左移一位，奇数位值右移一位，等效奇数位和偶数位交换
        even = even << 1;
        odd = odd >> 1;
        //把交换位置后的奇偶位合并
        return even | odd;
    }
}
