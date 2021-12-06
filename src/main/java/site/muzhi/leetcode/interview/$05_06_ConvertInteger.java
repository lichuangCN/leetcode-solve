package site.muzhi.leetcode.interview;

/**
 * @author lichuang
 * @date 2021/03/03
 * @description 整数转换
 * <p>
 * 编写一个函数，确定需要改变几个位才能将整数A转成整数B
 */
public class $05_06_ConvertInteger {

    public int convertInteger(int A, int B) {
        int res = A ^ B;
        int count = 0;
        while (res != 0) {
            if ((res & 1) == 1) {
                count++;
            }
            // A和B异或后，得到的结果可能是个负数，因此需要无符号右移
            res >>>= 1;
        }
        return count;
    }
}
