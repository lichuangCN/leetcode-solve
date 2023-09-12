package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/12
 * 169.多数元素
 */
public class $169_majorityElement {

    public int majorityElement(int[] nums) {
        int ans = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
                count++;
                continue;
            }
            if (ans != num) {
                count--;
            } else {
                count++;
            }
        }
        return ans;
    }
}
