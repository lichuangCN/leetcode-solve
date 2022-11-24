package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/22
 * 151.单词翻转
 */
public class $151_reverseWords {

    /**
     * 使用 String API
     */
    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }

        // 去除首尾空格
        s = s.trim();

        // 拆分单词
        String[] arr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if ("".equals(arr[i])) {
                continue;
            }
            builder.append(arr[i]).append(" ");
        }
        return builder.toString().trim();
    }

    /**
     * 指针遍历
     */
    public String reverseWords_2(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        // "  leet code "
        int start, end;
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                continue;
            }
            // 单词尾字母索引
            end = i;
            while (i >= 0 && ' ' != s.charAt(i)) {
                i--;
            }
            // 单词首字母索引
            start = i + 1;

            String word = s.substring(start, end + 1);
            builder.append(word).append(" ");
            // i
        }
        String ans = builder.toString();
        return ans.substring(0, ans.length() - 1);
    }

}
