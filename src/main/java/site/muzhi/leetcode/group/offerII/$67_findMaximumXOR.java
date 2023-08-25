package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/06/06
 * 67.最大的异或
 */
public class $67_findMaximumXOR {

    TrieNode root = new TrieNode();
    // 最高位的二进制位编号为 30
    final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            ans = Math.max(ans, getMax(nums[i]));
        }
        return ans;
    }

    private void add(int x) {
        TrieNode curr = root;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int idx = (x >> k) & 1;
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
    }

    private int getMax(int x) {
        int max = 0;
        TrieNode curr = root;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int idx = (x >> k) & 1;
            if (idx == 0) {
                // 去右侧
                if (curr.children[1] != null) {
                    curr = curr.children[1];
                    max = max * 2 + 1;
                } else {
                    curr = curr.children[0];
                    max = max * 2;
                }
            } else {
                // 去左侧
                if (curr.children[0] != null) {
                    curr = curr.children[0];
                    max = max * 2 + 1;
                } else {
                    curr = curr.children[1];
                    max = max * 2;
                }
            }
        }
        return max;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

}
