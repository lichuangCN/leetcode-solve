package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2022/03/03
 * @description 剑指 Offer 11. 旋转数组的最小数字
 * <p>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class $11_MinArray {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int left = 0, right = numbers.length - 1;

        // 左右两头数值相同
        while (0 < right && numbers[0] == numbers[right]) {
            right--;
        }

        // 排除右侧相同的数值，递增序列，则队首是最小值
        if (numbers[left] <= numbers[right]) {
            return numbers[left];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // mid逐步逼近目标值
            if (numbers[0] <= numbers[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return numbers[left];
    }
}
