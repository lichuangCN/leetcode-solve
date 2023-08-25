package site.muzhi.leetcode.clazz.interview.chapter5;

/**
 * @author lichuang
 * @date 2021/04/26
 * @description Excel表列序号
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xa6dkt/
 * <p>
 * 26进制转10进制
 */
public class $1_titleToNumber {

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || "".equals(columnTitle)) {
            return 0;
        }
        char[] arr = columnTitle.toCharArray();
        int res = 0;
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            res += (arr[i] - 64) * Math.pow(26, j);
        }
        return res;
    }
}
