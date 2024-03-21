package site.muzhi.leetcode.group.interview_75;

/**
 * @author lichuang
 * @date 2024/03/18
 * LCR.122 路径加密
 */
public class $LCR_122_pathEncryption {

    public String pathEncryption(String path) {
        char[] chars = path.toCharArray();

        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            if (c == '.') {
                ans.append("%20");
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
