package site.muzhi.array;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2020/12/24
 * @description 计数质数(素数)
 */
public class $204_CountPrimes {

    /**
     * ---------------------------质朴法---------------------------
     * 时间复杂度 n*sqrt(n)
     */
    public int countPrimes1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * ----------------------------埃氏筛--------------------------
     **/
    public int countPrimes2(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        // 从2开始枚举
        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {
                // 每次找当前素数x的倍数时，是从x^2开始的。
                // 因为如果x>2,那么2∗x肯定被素数2给过滤了
                // 最小未被过滤的肯定是 x^2
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        return count;
    }

}
