package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/09/27
 * @description 二叉搜索树的后序遍历序列
 */
public class $33_VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return search(postorder, 0, postorder.length - 1);
    }

    public boolean search(int[] postorder, int left, int right) {
        // 遍历完毕，right 左侧的值都小于right
        if (left >= right) {
            return true;
        }
        // 当前区间的根节点
        int root = postorder[right];
        int mid = left;
        // 从左向右寻找第一个大于root的值
        while (postorder[mid] < root) {
            mid++;
        }
        // 此时[mid,right)区间是右子树，即此区间的值都应大于postorder[right]
        // [left,mid)区间是左子树，即此区间的值都应小于postorder[right]
        int tem = mid;
        while (tem < right) {
            // 如果mid右侧还存在比[right]小的值,不符合后序遍历条件
            if (postorder[tem++] < postorder[right]) {
                return false;
            }
        }
        // 递归
        return search(postorder, left, mid - 1) && search(postorder, mid, right - 1);
    }

}
