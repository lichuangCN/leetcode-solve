package site.muzhi.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2021/02/26
 * @description
 */
public class $04_12_PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return count(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int count(TreeNode node, int sum, int target) {
        if (node == null) {
            return 0;
        }
        sum += node.val;
        return (sum == target ? 1 : 0) + count(node.left, sum, target) + count(node.right, sum, target);
    }

    /**
     * 前缀和方式
     * 递归-回溯
     * @param root
     * @param sum
     * @return
     */
    public int pathSum_1(TreeNode root, int sum) {
        // key前缀和，value此前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    public int recursionPathSum(TreeNode root, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        currSum += root.val;
        res += prefixSumCount.getOrDefault(currSum - target, 0);

        // 更新当前路径上前缀和
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // 处理子树节点
        res += recursionPathSum(root.left, prefixSumCount, target, currSum);
        res += recursionPathSum(root.right, prefixSumCount, target, currSum);

        // 重置前缀和
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }
}
