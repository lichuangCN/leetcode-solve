package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/04
 * @description 415. 字符串相加
 */
public class $415_addStrings {

    public String addStrings(String num1, String num2) {
        int ptr1 = num1.length() - 1, ptr2 = num2.length() - 1, add = 0;
        StringBuilder builder = new StringBuilder();
        while (ptr1 >= 0 && ptr2 >= 0) {
            int var1 = num1.charAt(ptr1--) - '0';
            int var2 = num2.charAt(ptr2--) - '0';

            int sum = var1 + var2 + add;
            add = sum / 10;
            builder.append(sum % 10);
        }

        //
        while (ptr1 >= 0) {
            int sum = num1.charAt(ptr1--) - '0' + add;
            add = sum / 10;
            builder.append(sum % 10);
        }
        while (ptr2 >= 0) {
            int sum = num2.charAt(ptr2--) - '0' + add;
            add = sum / 10;
            builder.append(sum % 10);
        }
        if (add > 0) {
            builder.append(add);
        }
        return builder.reverse().toString();
    }
}
