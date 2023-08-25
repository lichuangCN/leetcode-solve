package site.muzhi.leetcode.group.offerII;

import java.util.TreeSet;

/**
 * @author lichuang
 * @date 2023/05/18
 * 58.日程表
 */
public class $58_MyCalendar {

    class MyCalendar {

        TreeSet<int[]> calendar;

        public MyCalendar() {
            calendar = new TreeSet<>((x, y) -> x[0] - y[0]);
        }

        public boolean book(int start, int end) {
            if (calendar.isEmpty()) {
                calendar.add(new int[]{start, end});
                return true;
            }
            // t 用来寻找比 [start,end) 后的第一个日程
            int[] t = {end, 0};
            int[] next = calendar.ceiling(t);
            //
            int[] prev = next == null ? calendar.last() : calendar.lower(next);
            // prev == null 表明当前最小
            if (prev == null || prev[1] <= start) {
                calendar.add(new int[]{start, end});
                return true;
            }
            return false;
        }
    }
}
