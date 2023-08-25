package site.muzhi.leetcode.tree;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2021/03/12
 * @description 验证二叉树的前序序列化
 */
public class $331_IsValidSerialization {

    /**
     * 根据出入度计算
     * 任何图或者树中，入度=出度
     *
     * @param preorder
     * @return
     */
    public boolean isValidSerialization_1(String preorder) {

        String[] arr = preorder.split(",");
        if (arr.length == 1 && arr[0].equals("#")) {
            return true;
        }
        if (arr.length > 1 && arr[0].equals("#")) {
            return false;
        }

        int inDegree = 0, outDegree = 2;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals("#")) {
                inDegree += 1;
            } else {
                inDegree += 1;
                outDegree += 2;
            }
            // 只有在遍历完节点（包括空节点）后，入度=出度才成立
            if (i != arr.length - 1 && inDegree >= outDegree) {
                return false;
            }
        }
        return inDegree == outDegree;
    }

    /**
     * 栈方式
     *
     * @param preorder
     * @return
     */
    public boolean isValidSerialization_2(String preorder) {

        String[] arr = preorder.split(",");
        if (arr.length == 1 && arr[0].equals("#")) {
            return true;
        }
        if (arr.length > 1 && arr[0].equals("#")) {
            return false;
        }
        LinkedList<String> stack = new LinkedList<>();
        for (String s : arr) {
            stack.addLast(s);
            // LinkedList对指定位置的元素查询比较慢
            while ((stack.size() >= 3 && stack.get(stack.size() - 1).equals("#")
                    && stack.get(stack.size() - 2).equals("#") && !stack.get(stack.size() - 3).equals("#"))) {
                stack.removeLast();
                stack.removeLast();
                stack.removeLast();
                stack.addLast("#");
            }
        }
        return stack.size() == 1 && stack.peekLast().equals("#");
    }
}
