package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/19
 * 171.Excel 表列序号
 */
public class $171_titleToNumber {

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || "".equals(columnTitle)) {
            return 0;
        }
        // 16进制
        int len = columnTitle.length(), tar = 0;
        for (int i = len - 1; i >= 0; i--) {
            tar += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(16, len - i - 1);
        }
        return tar;
    }
}
