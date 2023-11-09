package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/08
 * 169.多数元素
 */
public class $169_majorityElement {

    public int majorityElement(int[] nums) {
        int count = 0, curr = 0;
        for (int num : nums) {
            if (count == 0) {
                curr = num;
                count++;
            } else {
                count = curr == num ? count + 1 : count - 1;
            }
        }
        return curr;
    }
}
