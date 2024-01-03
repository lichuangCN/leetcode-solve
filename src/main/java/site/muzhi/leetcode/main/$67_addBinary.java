package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/03
 * 67.二进制求和
 */
public class $67_addBinary {

    public String addBinary(String a, String b) {
        int lenA = a.length(), lenB = b.length(), ptrA = lenA - 1, ptrB = lenB - 1;
        StringBuilder ans = new StringBuilder();
        int add = 0;
        while (ptrA >= 0 || ptrB >= 0) {
            int numA = ptrA >= 0 ? Integer.valueOf(a.charAt(ptrA) - '0') : 0;
            int numB = ptrB >= 0 ? Integer.valueOf(b.charAt(ptrB) - '0') : 0;
            int sum = numA + numB + add;
            add = sum / 2;
            ans.append(sum % 2);
            ptrA--;
            ptrB--;
        }
        if (add != 0) {
            ans.append(add);
        }
        return ans.reverse().toString();
    }
}
