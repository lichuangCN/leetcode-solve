package site.muzhi.leetcode.main;

/**
 * @author: lichuang
 * @date: 2020/03/05
 * @description: 排排坐，分糖果。
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，
 * 依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），
 * 直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），
 * 这些糖果也会全部发给当前的小朋友。
 * 返回一个长度为 num_people、元素之和为 candies 的数组，
 * 以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数
 */

public class $1103_DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        if (candies == 0 || num_people == 0) {
            return new int[num_people];
        }

        int i = 0;
        // 每次分发糖果的数目，初始为1
        int count = 1;
        // 结果数组
        int[] results = new int[num_people];
        while (candies > 0) {
            // 如果剩余的糖果可以分给当前的孩子
            if (candies >= count) {
                // 通过i累加并对num_people取余可以计算出下一次分配糖果的孩子的位置
                results[i % num_people] += count;
                // 剩余的糖果数
                candies -= count;
                i++;
                // 下次分配糖果数目+1
                count++;
            } else {
                // 剩余糖果不够分给当前孩子，则全部给当前孩子
                results[i % num_people] += candies;
                candies = 0;
            }
        }
        return results;
    }
}
