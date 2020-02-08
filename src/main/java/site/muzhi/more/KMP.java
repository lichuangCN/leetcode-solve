package site.muzhi.more;

/**
 * Author: lichuang
 * Date: Create in 16:36 2019/11/27
 * Description:
 * KMP算法
 */

public class KMP {

    public static void main(String[] args) {
        String target = "ABCDABCE";
        String pattern = "ABCE";
        int index = searchKMP(target, pattern);
        System.out.println("index: " + index);

    }

    public static int searchKMP(String target, String pattern) {

        // int[] next = getNextArray(pattern);
        int[] next = getNextValArray(pattern);

        // 目标串
        char[] t = target.toCharArray();
        // 模式串
        char[] p = pattern.toCharArray();

        int i = 0, j = 0, sL = t.length, pL = p.length;
        while (i < sL && j < pL) {
            // 如果i==-1，表明匹配成功，然后i++,j++
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        //匹配成功，返回模式串p在文本串s中的位置，否则返回-1
        if (j == pL) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * 获取模式串的next[]
     *
     * @param pattern
     * @return
     */
    public static int[] getNextArray(String pattern) {
        int[] next = new int[pattern.length()];
        char[] p = pattern.toCharArray();

        int j = 0, k = -1;
        // 第一位设为-1，方便判断当前位置是否为搜索词的最开始
        next[0] = -1;
        while (j < pattern.length() - 1) {
            if (k == -1 || p[j] == p[k]) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    /**
     * 优化过后的next[]
     * @param pattern
     * @return
     */
    public static int[] getNextValArray(String pattern) {
        int[] next = new int[pattern.length()];
        char[] p = pattern.toCharArray();

        int j = 0, k = -1;
        // 第一位设为-1，方便判断当前位置是否为搜索词的最开始
        next[0] = -1;
        while (j < pattern.length() - 1) {
            if (k == -1 || p[j] == p[k]) {
                j++;
                k++;
                // 优化部分
                if (p[j] != p[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
