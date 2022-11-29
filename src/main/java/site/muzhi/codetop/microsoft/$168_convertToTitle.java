package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/29
 * @description 168. Excel表列名称
 * <p>
 * 26进制转换
 */
public class $168_convertToTitle {

    public String convertToTitle(int cn) {
        if (cn < 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        while (cn > 0) {
            cn--;
            builder.append((char) (cn % 26 + 'A'));

            cn /= 26;
        }
        builder.reverse();
        return builder.toString();
    }


}
