package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/11
 * 416.汉明距离
 */
public class $461_hammingDistance {

    public int hammingDistance(int x, int y) {
        int tar = x ^ y;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (tar & 1) == 1 ? ans + 1 : ans;
            tar >>= 1;
        }
        return ans;
    }
}
