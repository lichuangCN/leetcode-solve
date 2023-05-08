package site.muzhi.leetcode.offerII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/05/08
 * 44.二叉树每层的最大值
 */
public class $44_largestValues {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> levelQueue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        levelQueue.addLast(root);
        ans.add(root.val);

        // 最大堆
        while (!levelQueue.isEmpty()) {
            int size = levelQueue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = levelQueue.pollFirst();
                if (node.left != null) {
                    levelQueue.addLast(node.left);
                    max = Math.max(max, node.left.val);
                }
                if (node.right != null) {
                    levelQueue.addLast(node.right);
                    max = Math.max(max, node.right.val);
                }
            }
            ans.add(max);
        }
        return ans;
    }

    class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
