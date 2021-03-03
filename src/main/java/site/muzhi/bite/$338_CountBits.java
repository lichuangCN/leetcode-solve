package site.muzhi.bite;

/**
 * @author lichuang
 * @date 2021/03/03
 * @description 比特位计数
 */
public class $338_CountBits {

    /**
     * 暴力解决
     * 时间复杂度O(n*sizeof(int))
     *
     * @param num
     * @return
     */
    public int[] countBits_1(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int idx = i;
            int count = 0;
            while (idx != 0) {
                if ((idx & 1) == 1) {
                    count++;
                }
                idx >>= 1;
            }
            res[i] = count;
        }
        return res;
    }

    /**
     * 优化
     * n和n/2两个数之间，bit位上1的个数差取决于最后一位
     * 奇数：res[n] = res[n/2] + 1
     * 偶数：res[n] = res[n/2]
     *
     * @param num
     * @return
     */
    public int[] countBits_2(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

}
