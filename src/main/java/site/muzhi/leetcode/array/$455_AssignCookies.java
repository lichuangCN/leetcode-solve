package site.muzhi.leetcode.array;

import java.util.Arrays;

/**
 * @author: LiChuang
 * @date: 2020/02/19
 * @description: 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 * 但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，
 * 这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj。
 * 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 */
public class $455_AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0, count = 0;
        // kid：每个孩子的需求
        for (int kid : g) {
            while (j < s.length) {
                // s[j] 饼干大小
                if (s[j] > kid) {
                    // 当前饼干满足孩子需求
                    count++;
                    j++;
                    break;
                }
                j++;
            }
        }
        return count;
    }

}
