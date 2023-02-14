package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/02/14
 * 二进制加法
 */
public class $2_addBinary {

    public String addBinary(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int aPtr = aArr.length - 1, bPtr = bArr.length - 1, add = 0;
        StringBuilder builder = new StringBuilder();
        while (aPtr >= 0 && bPtr >= 0) {
            int sum = aArr[aPtr] - '0' + bArr[bPtr] - '0' + add;
            builder.append(sum % 2);
            add = sum / 2;
            aPtr--;
            bPtr--;
        }
        while (aPtr >= 0) {
            int sum = aArr[aPtr] - '0' + add;
            builder.append(sum % 2);
            add = sum / 2;
            aPtr--;
        }
        while (bPtr >= 0) {
            int sum = bArr[bPtr] - '0' + add;
            builder.append(sum % 2);
            add = sum / 2;
            bPtr--;
        }
        if (add > 0) {
            builder.append(add);
        }
        return builder.reverse().toString();
    }
}
