package site.muzhi.leetcode.bite;

/**
 * @author lichuang
 * @date 2021/05/16
 * @description 421. 数组中两个数的最大异或值
 * <p>
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class $421_findMaximumXOR {

    class Node {
        // [0]:表示bit位0，[1]:表示bit位1
        Node[] ns = new Node[2];
    }

    Node root = new Node();

    /**
     * 将数字按照bit位存储
     *
     * @param x
     */
    private void add(int x) {
        Node cur = this.root;
        for (int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1;
            if (cur.ns[bit] == null) {
                cur.ns[bit] = new Node();
            }
            cur = cur.ns[bit];
        }
    }

    private int getVal(int x) {
        int ans = 0;
        Node cur = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1, anti = 1 - bit;
            if (cur.ns[anti] != null) {
                ans |= (anti << i);
                cur = cur.ns[anti];
            } else {
                ans |= (bit << i);
                cur = cur.ns[bit];
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int num : nums) {
            add(num);
            int val = getVal(num);
            res = Math.max(res, num ^ val);
        }
        return res;
    }
}
