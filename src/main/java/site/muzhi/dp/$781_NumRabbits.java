package site.muzhi.dp;

/**
 * @author lichuang
 * @date 2021/04/04
 * @description 781. 森林中的兔子
 * <p>
 * https://leetcode-cn.com/problems/rabbits-in-forest/
 */
public class $781_NumRabbits {

    public int numRabbits(int[] answers) {
        int n = answers.length;
        if (n == 0) {
            return 0;
        }
        int[] count = new int[1000];
        int res = 0;
        for (int answer : answers) {
            if (count[answer] > 0) {
                count[answer]--;
            } else {
                res += (answer + 1);
                count[answer] = answer;
            }
        }
        return res;
    }
}
