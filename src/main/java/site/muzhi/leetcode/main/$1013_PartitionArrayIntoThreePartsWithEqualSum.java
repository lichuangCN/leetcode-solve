package site.muzhi.leetcode.array;

/**
 * @author: lichuang
 * @date: 2020/03/11
 * @description: 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * <p>
 * 首选算A的累加和能否被3整除，不可以那分不了3等分。
 * 双指针前后向中间逼近，不用考虑中间那段怎么分，
 * 只要左右两段累加和等于3等分的数值，中间剩的那段也就找到了。
 */
public class $1013_PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A.length == 0) {
            return false;
        }
        // 数组之和
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        // 如果数组之和不能被3整除，则表示当前数组不能被分为三等分
        if (sum % 3 != 0) {
            return false;
        }
        int part = sum / 3;
        // partSum划分数组之和，count表示找到几段符合条件的数组段
        int partSum = 0, count = 0;
        for (int a : A) {
            partSum += a;
            // 当找到一段时，记录
            if (partSum == part) {
                count++;
                partSum = 0;
            }
        }
        // 计算出来的count数大于3时，part=0
        return (count == 3) || (count > 3 && part == 0);
    }
}
