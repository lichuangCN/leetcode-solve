package site.muzhi.interview;

/**
 * @author: lichuang
 * @date: 2020/03/16
 * @description: 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
 * 则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 */

public class $01_06_CompressStringLcci {

    public String compressString(String S) {
        // 当S长度等于1时，压缩后的字符串长度为2，大于原始长度
        if (S == null || "".equals(S) || S.length() == 1) {
            return S;
        }
        StringBuilder result = new StringBuilder();
        // 字符串索引
        int index = 0;
        while (index < S.length()) {
            // 默认当前字符出现次数为1
            int count = 1;
            while (index + 1 < S.length() && S.charAt(index) == S.charAt(index + 1)) {
                // 如果下一位字符和当前字符相同，则出现次数+1
                count++;
                // 指针右移
                index++;
            }
            // 此时当前指向字符与下一位字符不同，因此在拼接完字符串后，指针要指向下一位字符
            result.append(S.charAt(index++)).append(count);
        }
        // 根据得到的字符串长度，选择返回符合要求的字符串
        return (result.toString().length() < S.length()) ? result.toString() : S;
    }
}
