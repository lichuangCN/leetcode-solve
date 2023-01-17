package site.muzhi.codetop.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/01/04
 * 437.路径总和 III
 */
public class $437_pathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        // key 前缀和；Long 纯属测试用例有病
        // value 前缀和 = key 出现的次数
        Map<Long, Integer> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0L, 1);
        return travel(root, prefixCountMap, targetSum, 0L);
    }

    public int travel(TreeNode node, Map<Long, Integer> prefixCountMap, int targetSum, long currSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        //
        int res = 0;
        currSum += node.val;
        // 获取前缀和 = currSum - targetSum 出现的次数
        res += prefixCountMap.getOrDefault(currSum - targetSum, 0);
        // 更新前缀和 = currSum 出现的次数
        prefixCountMap.put(currSum, prefixCountMap.getOrDefault(currSum, 0) + 1);

        // 下一层
        res += travel(node.left, prefixCountMap, targetSum, currSum);
        res += travel(node.right, prefixCountMap, targetSum, currSum);

        // 恢复当前层
        prefixCountMap.put(currSum, prefixCountMap.get(currSum) - 1);
        return res;
    }
}
