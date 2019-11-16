package site.muzhi.solve;

/**
 * Author: lichuang
 * Date: Create in 17:49 2019/11/15
 * Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 如
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 思路：
 * 1、将第一个字符串作为最长公共前缀
 * 2、将后面的字符串循环与最长公共前缀进行比较
 * 3、出现不同字符时，停止当前字符串的比较，并且重新截取最长公共前缀
 * 4、进行3操作
 */

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs == null) {
            return "";
        }

        // 将第一个字符串作为最长公共前缀
        String index = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // 第一个字符串和第i个字符串比较
            for (; j < index.length() && j < strs[i].length(); j++) {
                // 两个字符串中出现字符不一样
                if (index.charAt(j) != strs[i].charAt(j)) {
                    break; // 跳出循环,与下一个字符串进行比较
                }
            }
            // 截取公共前缀字符串,用于和下一个字符串比较
            index = index.substring(0, j);
            // 如果公共前缀为空
            if (index.equals("")) {
                return index;
            }
        }
        return index;
    }
}
