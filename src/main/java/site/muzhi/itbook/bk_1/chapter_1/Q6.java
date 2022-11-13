package site.muzhi.itbook.bk_1.chapter_1;

import java.util.List;

/**
 * @author lichuang
 * @date 2022/10/30
 * @description 汉诺塔
 */
public class Q6 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        move(A.size(), A, B, C);
    }

    private void move(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }

        //
        move(size - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(size - 1, B, A, C);
    }
}
