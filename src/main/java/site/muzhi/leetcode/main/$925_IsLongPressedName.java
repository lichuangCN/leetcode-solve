package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/10/21
 * @description 长按键入
 * <p>
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 */
public class $925_IsLongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        if ((name == null && typed != null) || (name != null && typed == null)) {
            return false;
        }
        if (name == null && typed == null) {
            return true;
        }
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        if (i == name.length()) {
            return true;
        } else {
            return false;
        }
    }
}
