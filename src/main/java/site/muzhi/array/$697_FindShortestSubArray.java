package site.muzhi.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2021/02/20
 * @description 数组的度
 */
public class $697_FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        // int[] 0:出现次数,1:最早出现位置2:最后出现位置
        Map<Integer, int[]> counter = new HashMap<>();
        // 数组的度
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (counter.containsKey(num)) {
                int[] arr = counter.get(num);
                arr[0]++;
                arr[2] = i;
                count = Math.max(count, arr[0]);
            } else {
                int[] arr = {1, i, i};
                counter.put(num, arr);
                count = Math.max(count, arr[0]);
            }
        }
        // 最短长度
        int len = nums.length;
        for (Map.Entry<Integer, int[]> entry : counter.entrySet()) {
            int[] arr = entry.getValue();
            if (arr[0] == count) {
                len = Math.min(arr[2] - arr[1] + 1, len);
            }
        }
        return len;
    }
}
