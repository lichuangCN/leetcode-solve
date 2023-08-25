package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/12/09
 * @description 278. 第一个错误的版本
 * <p>
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class $278_FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 0, r = n;
        while (l < n) {
            int mid = l + (r - l) / 2;
            if (!isBadVersion(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public boolean isBadVersion(int v) {
        return false;
    }
}
