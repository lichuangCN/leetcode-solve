package site.muzhi.string;

/**
 * @author lichuang
 * @date 2020/09/24
 * @description 字符的最短距离
 * <p>
 * 给定一个字符串 S 和一个字符 C。
 * 返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 */
public class $821_ShortestToChar {
    public int[] shortestToChar(String S, char C) {
        if (S == null || S == "") {
            return new int[0];
        }
        int[] res = new int[S.length()];
        // 指向上一个值为C的位置
        int pre = Integer.MIN_VALUE / 2;
        // 以左边为基准点，向右移动
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                pre = i;
            }
            res[i] = i - pre;
        }
        // 以右边为基准点,向左移动
        pre = Integer.MAX_VALUE / 2;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                pre = i;
            }
            // 去当前点距离左右两侧C值的距离的最小值
            res[i] = Math.min(res[i], pre - i);
        }
        return res;
    }
}
