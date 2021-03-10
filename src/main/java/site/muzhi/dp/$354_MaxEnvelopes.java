package site.muzhi.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/03/04
 * @description 俄罗斯套娃
 */
public class $354_MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        // 根据维度二(y)进行排序，在根据维度一(x)排序
        List<int[]> list = Arrays.asList(envelopes);
        Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);

        // 更加精简版的Lambda表达式
        // Collections.sort(list, Comparator.comparingInt(o -> o[1]));
        // Collections.sort(list, Comparator.comparingInt(o -> o[0]));

        int[] dp = new int[list.size()];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < list.size(); i++) {
            int[] curr = list.get(i);
            for (int j = 0; j < i; j++) {
                int[] pre = list.get(j);
                if (curr[0] > pre[0] && curr[1] > pre[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
