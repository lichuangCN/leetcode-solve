package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/12/27
 * 6.N字形变换
 */
public class $6_convert {

    public String convert(String s, int numRows) {
        if (s.length() <= 2) {
            return s;
        }
        List<StringBuilder> grid = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            grid.add(new StringBuilder());
        }

        int idx = 0, mov = -1;
        for (char c : s.toCharArray()) {
            grid.get(idx).append(c);
            // 到达顶点转向
            if (idx == 0 || idx == numRows - 1) {
                mov = -mov;
            }
            idx += mov;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder b : grid) {
            ans.append(b.toString());
        }
        return ans.toString();
    }
}
