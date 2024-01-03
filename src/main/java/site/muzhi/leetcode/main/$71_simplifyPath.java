package site.muzhi.leetcode.main;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2024/01/03
 * 71.简化路径
 */
public class $71_simplifyPath {
    public String simplifyPath(String path) {


        int len = path.length(), i = 0;
        // 格式化 '/'
        StringBuilder replace = new StringBuilder();
        while (i < len) {
            if (path.charAt(i) == '/') {
                replace.append("/");
                while (i < len && path.charAt(i) == '/') i++;
            } else {
                replace.append(path.charAt(i));
                i++;
            }
        }
        path = replace.toString();

        String[] pathArr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : pathArr) {
            if ("".equals(s)) {
                continue;
            }
            // 当前目录 不做任何操作
            if (".".equals(s)) {
                continue;
            }
            // 返回上一层目录
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            // 文件夹
            stack.push(s);
        }
        return "/" + String.join("/", stack);
    }
}
