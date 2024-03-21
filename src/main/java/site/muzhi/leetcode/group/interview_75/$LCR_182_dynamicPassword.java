package site.muzhi.leetcode.group.interview_75;

/**
 * @author lichuang
 * @date 2024/03/18
 * LCR.182 动态口令
 */
public class $LCR_182_dynamicPassword {

    public String dynamicPassword(String password, int target) {
        return password.substring(target, password.length()) + password.substring(0, target);
    }
}
