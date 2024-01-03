package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2023/12/28
 * 748.最短补全词
 */
public class $748_shortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = parse(licensePlate);

        String ans = "";
        for (String word : words) {
            int[] tar = parse(word);
            if (check(count, tar)) {
                if (ans == "") {
                    ans = word;
                } else {
                    ans = ans.length() > word.length() ? word : ans;
                }
            }
        }
        return ans;
    }

    private int[] parse(String s) {
        int[] count = new int[26];
        for (char c : s.toLowerCase().toCharArray()) {
            // 过滤数字和空格
            if (Character.isDigit(c) || c == ' ') {
                continue;
            }
            count[c - 'a']++;
        }
        return count;
    }

    private boolean check(int[] count, int[] tar) {
        for (int i = 0; i < tar.length; i++) {
            if (tar[i] < count[i]) {
                return false;
            }
        }
        return true;
    }
}
