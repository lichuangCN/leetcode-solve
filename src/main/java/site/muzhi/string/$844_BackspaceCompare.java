package site.muzhi.string;

/**
 * @author lichuang
 * @date 2020/10/19
 * @description 比较含退格的字符串
 */
public class $844_BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        if (S == null && T == null) {
            return true;
        }
        if (S == null || T == null) {
            return false;
        }
        return validString(S).equals(validString(T));
    }

    private String validString(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            builder.append(c);
            if (c == '#') {
                // 移除新加的'#'
                builder.deleteCharAt(builder.length() - 1);
                if (builder.length() > 0) {
                    // 移除最后一个字符
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }
        return builder.toString();
    }
}
