package site.muzhi.leetcode.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/05/10
 * 50.向下的路径节点之和
 */
public class $50_pathSum {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> sumMap = new HashMap<>();
        sumMap.put(0L, 1);
        return travel(root, sumMap, targetSum, 0);
    }

    public int travel(TreeNode node, Map<Long, Integer> sumMap, int target, long currSum) {
        if (node == null) {
            return 0;
        }
        currSum += node.val;
        int res = sumMap.getOrDefault(currSum - target, 0);
        // 更新 currSum出现的次数
        sumMap.put(currSum, sumMap.getOrDefault(currSum, 0) + 1);
        res += travel(node.left, sumMap, target, currSum);
        res += travel(node.right, sumMap, target, currSum);

        sumMap.put(currSum, sumMap.get(currSum) - 1);
        return res;
    }

    class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;
    }
}
