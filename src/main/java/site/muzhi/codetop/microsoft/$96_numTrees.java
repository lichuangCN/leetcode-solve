package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/09
 * @description 96. 不同的二叉搜索树
 * <p>
 * 1.根节点不同的树，生成的二叉搜索树必定不同
 * 2.G(n)：长度为n的序列能生成的二叉搜索树的个数
 * 3.F(i,n)：以i为根节点，序列长度为n的二叉搜索树的个数（1<=i<=n）
 * G(n)= F(1,n) + F(2,n) + ... + F(n,n)
 * // 即i节点左侧生成的个数 * i节点右侧生成的个数
 * F(i,n) = G(i-1) * G(n-i)
 * G(n) = G(0) * G(n-1) + G(1)*G(n-2) + ... + G(n-1) * G(0)
 */
public class $96_numTrees {

    public int numTrees(int n) {
        // 初始化
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        // k:表示当前长度=k时，生成二叉搜索树的个数
        for (int k = 2; k <= n; k++) {
            // 以i为根节点
            // i-1 表示左侧节点数, k-i 表示右侧节点数
            for (int i = 1; i <= k; i++) {
                G[k] += G[i - 1] * G[k - i];
            }
        }
        return G[n];
    }
}
