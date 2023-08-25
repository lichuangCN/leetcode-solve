package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2022/02/22
 * @description 119.杨辉三角 II
 * <p>
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class $119_GetRow {

    /**
     * 本题可从新的一行的末尾开始向前填充
     * <p>
     * dp状态转移方程：
     * i:行数，j行内元素位置
     * 初始值 row(0,0)=1;
     * row(i+1,j) = row(i,j)+row(i,j-1)
     */
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex <= 0) {
            return new ArrayList<>();
        }

        List<Integer> row = new ArrayList<>();
        row.add(1);
        // i:行循环，从第2行开始
        for (int i = 1; i <= rowIndex; i++) {
            // 为新的一行提前添加一个值
            row.add(0);
            // 行内循序填充，从第二行开始
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
}
