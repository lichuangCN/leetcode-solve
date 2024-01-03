package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2023/12/27
 * 2660.保龄球游戏的获胜者
 */
public class $2660_isWinner {

    public int isWinner(int[] player1, int[] player2) {
        int sum1 = 0, sum2 = 0, len = player1.length;
        for (int i = 0; i < len; i++) {
            int multi1 = (i >= 1 && player1[i - 1] == 10) || (i >= 2 && player1[i - 2] == 10) ? 2 : 1;
            int multi2 = (i >= 1 && player2[i - 1] == 10) || (i >= 2 && player2[i - 2] == 10) ? 2 : 1;
            sum1 += multi1 * player1[i];
            sum2 += multi2 * player2[i];
        }
        if (sum1 == sum2) {
            return 0;
        } else if (sum1 > sum2) {
            return 1;
        } else {
            return 2;
        }
    }
}
