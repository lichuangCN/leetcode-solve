package site.muzhi.array;

/**
 * @author: lichuang
 * @date: 2020/03/10
 * @description: 给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class $136_SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 0;
        // 采用异或运算，出现两次相同的数经过异或运算后为0
        // 因此剩余的数为单身数
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
