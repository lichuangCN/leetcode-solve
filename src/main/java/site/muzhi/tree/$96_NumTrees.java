package site.muzhi.tree;

/**
 * @author lichuang
 * @date 2020/08/20
 * @description 不同的二叉搜索树
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种
 * <p>
 * 假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
 * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
 * 同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
 */
public class $96_NumTrees {

    public int numTrees(int n) {
        int[] res = new int[n + 1];
        // 默认一侧为0个节点时表示只有一种情况
        res[0] = 1;
        // 当一侧节点数为1时，只有一种情况
        res[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            // j 表示左侧节点数, i-j-1 表示右侧节点数
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }
}
