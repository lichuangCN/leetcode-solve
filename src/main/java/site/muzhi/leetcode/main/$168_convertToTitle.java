package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2023/12/25
 * 168.Excel表列名称
 */
public class $168_convertToTitle {

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            //
            columnNumber--;
            ans.append((char) ('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        return ans.reverse().toString();
    }
}
