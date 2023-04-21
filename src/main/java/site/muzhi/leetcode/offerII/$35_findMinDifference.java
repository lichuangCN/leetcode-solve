package site.muzhi.leetcode.offerII;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lichuang
 * @date 2023/04/21
 * 35.最小时间差
 */
public class $35_findMinDifference {

    public static void main(String[] args) {
        $35_findMinDifference demo = new $35_findMinDifference();

        System.out.println(demo.findMinDifference(Arrays.asList("05:31", "22:08", "00:35")));
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.isEmpty()) {
            return 0;
        }
        // 转换并排序
        int max = 24 * 60;
        List<Integer> convert = timePoints.stream().map(e -> {
            String[] arr = e.split(":");
            int curr = Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
            return curr == 0 ? max : curr;
        }).sorted().collect(Collectors.toList());

        int ans = max;
        int size = convert.size();
        for (int i = 0; i < size - 1; i++) {
            ans = Math.min(ans, convert.get(i + 1) - convert.get(i));
        }

        // 处理跨天
        ans = Math.min(ans, convert.get(0) + max - convert.get(size - 1));
        return ans;
    }
}
