package site.muzhi.codetop.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2024/01/25
 * LCR 174 寻找二叉搜索树中的目标节点
 */
public class $offer_$54_findTargetNode {
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int findTargetNode(TreeNode root, int cnt) {
        List<Integer> queue = new ArrayList<>();
        travel(root, queue);
        return queue.get(queue.size() - cnt);
    }

    public void travel(TreeNode root, List<Integer> queue) {
        if (root == null) {
            return;
        }
        travel(root.left, queue);
        queue.add(root.val);
        travel(root.right, queue);
    }
}
