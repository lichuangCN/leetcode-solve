package site.muzhi.string;

/**
 * @author lichuang
 * @date 2020/10/12
 * @description 反转字符串(空间复杂度O(1))
 */
public class $344_ReverseString {

    public void reverseString(char[] s) {

        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
