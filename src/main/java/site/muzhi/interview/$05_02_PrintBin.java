package site.muzhi.interview;

/**
 * @author lichuang
 * @date 2021/02/28
 * @description 二进制数转字符串
 */
public class $05_02_PrintBin {
    public String printBin(double num) {
        if (num <= 0 || num >= 1) {
            return "ERROR";
        }
        StringBuilder res = new StringBuilder();
        res.append("0.");
        while (num != 0) {
            num *= 2;
            if (num >= 1) {
                res.append("1");
                num--;
            } else {
                res.append("0");
            }
            if (res.length() > 32) {
                return "ERROR";
            }
        }
        return res.toString();
    }
}
