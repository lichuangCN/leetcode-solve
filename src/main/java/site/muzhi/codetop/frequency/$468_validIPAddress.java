package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/17
 * 468.验证IP地址
 */
public class $468_validIPAddress {

    // x1:x2:x3:x4:x5:x6:x7:x8 min
    // x1.x2.x3.x4
    public String validIPAddress(String queryIP) {
        if (queryIP == null || "".equals(queryIP)) {
            return "Neither";
        }
        if (queryIP.charAt(queryIP.length() - 1) == ':' ||
                queryIP.charAt(0) == ':' ||
                queryIP.charAt(queryIP.length() - 1) == '.' ||
                queryIP.charAt(0) == '.') {
            return "Neither";
        }
        if (isIPv4(queryIP)) {
            return "IPv4";
        }
        if (isIPv6(queryIP)) {
            return "IPv6";
        }

        return "Neither";
    }

    private boolean isIPv6(String queryIP) {
        String[] split = queryIP.split(":");
        if (split.length != 8) {
            return false;
        }
        for (String s : split) {
            if ("".equals(s) || s.length() > 4) {
                return false;
            }
            // 判断出现0-9 a-z A-Z以外的字符
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                boolean isDigit = Character.isDigit(c);
                boolean isLetter = (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
                if (!isDigit && !isLetter) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isIPv4(String queryIP) {
        String[] split = queryIP.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String s : split) {
            //
            if ("".equals(s) || s.length() > 3) {
                return false;
            }
            // 判断出现0-9以外的字符
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
            // 0开头
            if (s.length() > 1 && s.charAt(0) == '0') {
                return false;
            }
            if (Integer.valueOf(s) > 255) {
                return false;
            }
        }
        return true;
    }
}
