package site.muzhi.leetcode.group.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/10/10
 * 437.路径总和 III
 */
public class $437_pathSum {

    public int pathSum(TreeNode root, int targetSum) {
        // value 前缀和 = key 出现的次数
        Map<Long, Integer> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0L, 1);
        return travel(root, targetSum, 0L, prefixCountMap);
    }

    public int travel(TreeNode node, int targetSum, Long sum, Map<Long, Integer> prefixSum) {
        if (node == null) {
            return 0;
        }
        sum += node.val;
        int res = prefixSum.getOrDefault(sum - targetSum, 0);
        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);

        res += travel(node.left, targetSum, sum, prefixSum);
        res += travel(node.right, targetSum, sum, prefixSum);

        prefixSum.put(sum, prefixSum.get(sum) - 1);
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left, right;
    }
}
