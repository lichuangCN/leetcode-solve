package site.muzhi.array;

/**
 * @author lichuang
 * @date 2021/01/21
 * @description 三个数的最大乘积
 */
public class $628_MaximumProduct {

    /**
     * 寻找最大的三个值和最小的两个值
     *
     * @param nums
     * @return
     */
    public int maximumProduct_2(int[] nums) {
        // 1-3 最小/大 ---> 次小/大
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    /**
     * 暴力不可取啊
     *
     * @param nums
     * @return
     */
    public int maximumProduct_1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    int temp = nums[i] * nums[j] * nums[k];
                    if (temp > result) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }
}
