package site.muzhi.leetcode.group.interview;

import java.util.List;

/**
 * @author lichuang
 * @date 2021/03/09
 * @description
 */
public class $08_06_Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    // A:原始盘 B:中间盘 C:目标盘
    private void move(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        // 借助C将size-1个圆盘从A移动到B
        move(size - 1, A, C, B);
        // 将A的最后一个移动到C
        C.add(A.remove(A.size() - 1));
        // 借助A将size-1个圆盘从B移动到C
        move(size - 1, B, A, C);
    }
}
