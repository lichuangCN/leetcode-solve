package site.muzhi.string;

/**
 * @author lichuang
 * @date 2020/12/16
 * @description 单调递增的数字
 * <p>
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $738_MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        char[] charArray = String.valueOf(N).toCharArray();
        for (int i = charArray.length - 1; i > 0; i--) {
            if (charArray[i - 1] > charArray[i]) {
                --charArray[i - 1];
                // 后面的位置全部补为9
                for (int j = i; j < charArray.length; j++) {
                    charArray[j] = '9';
                }
            }
        }
        return Integer.valueOf(String.valueOf(charArray));
    }
}
