package site.muzhi.leetcode.group.tencent50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/11/08
 * 230.二叉搜索树中第k小的元素
 */
public class $230_kthSmallest {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        travel(root, list);
        return list.get(k - 1);
    }

    private void travel(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        travel(root.left, list);
        list.add(root.val);
        travel(root.right, list);
    }
}
