package site.muzhi.leetcode.array;

/**
 * @author: lichuang
 * @date: 2020/03/11
 * @description: 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 */

public class $344_ReverseString {

    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        // 两个指针指向两侧需要进行交换的元素
        int left = 0, right = s.length - 1;
        while (left < right) {
            // 交换完成后，左右两个指针同时向中间移动
            char c = s[left];
            s[left++] = s[right];
            s[right--] = c;
        }
    }
}
