package site.muzhi.leetcode.more;

/**
 * @author lichuang
 * @date 2020/08/28
 * @description 机器人能否返回原点
 */
public class $657_JudgeCircle {

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return false;
        }
        int length = moves.length();
        // 水平和竖直方向的位移
        int h = 0, v = 0;
        for (int i = 0; i < length; i++) {
            char c = moves.charAt(i);
            if (c == 'R') {
                h += 1;
            } else if (c == 'L') {
                h -= 1;
            } else if (c == 'U') {
                v += 1;
            } else if (c == 'D') {
                v -= 1;
            } else {
                return false;
            }
        }

        return (h == 0) && (v == 0);
    }
}
