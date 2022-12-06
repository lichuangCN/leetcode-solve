package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/06
 * @description 283. 移动零
 */
public class $283_moveZeroes {

    public void moveZeroes(int[] nums) {
        int curr = 0, len = nums.length;

        for (int i = 0; i < len; i++) {
            //
            if (nums[i] != 0) {
                nums[curr++] = nums[i];
            }
        }

        // 后面设置为0
        for (int i = curr; i < len; i++) {
            nums[i] = 0;
        }
    }
}
