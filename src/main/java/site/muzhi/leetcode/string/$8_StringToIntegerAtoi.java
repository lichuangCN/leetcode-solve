package site.muzhi.leetcode.string;

/**
 * @author: lichuang
 * @date: 2020/04/03
 * @description: 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */

public class $8_StringToIntegerAtoi {

    public int myAtoi(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        int index = 0, result = 0, len = str.length();
        // 处理前面的空格
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }
        // 处理正负值，false：表示+，true：表示-
        boolean ope = false;
        if (str.charAt(index) == '+') {
            ope = false;
            index++;
        } else if (str.charAt(index) == '-') {
            ope = true;
            index++;
        } else if (!Character.isDigit(str.charAt(index))) {
            // 遇到其它非法字符
            return 0;
        }
        // 处理字符
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE, res = 0;
        while (index < len && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            // 应该是 res*10+digit>max，但是存在左侧溢出的情况，将移到右边进行
            if (res > (max - digit) / 10) {
                // 如果超出范围，根据正负返回最值
                return (ope) ? min : max;
            }
            res = res * 10 + digit;
            index++;
        }
        // 如果未溢出，返回正负值
        return ope ? -res : res;
    }
}
