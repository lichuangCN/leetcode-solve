package site.muzhi.string;

/**
 * @author lichuang
 * @date 2021/05/14
 * @description 12. 整数转罗马数字
 * <p>
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class $12_intToRoman {

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int[] val = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < val.length; i++) {
            int v = val[i];
            String s = symbol[i];
            while (num >= v) {
                num -= v;
                builder.append(s);
            }
            if (num == 0) {
                break;
            }
        }
        return builder.toString();
    }

}
