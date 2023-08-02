package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/02
 * 169.多数元素
 */
public class $169_majorityElement {


    public int majorityElement(int[] nums) {
        //  对子 一个目标值对冲一个其他值
        int ans = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
                count++;
                continue;
            }
            if (ans == num) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }
}
