package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/04
 */
public class $136_singleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = (ans ^ num);
        }
        return ans;
    }
}
