package site.muzhi.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/01/15
 * @description 可被 5 整除的二进制前缀
 */
public class $1018_PrefixesDivBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        if (A == null || A.length == 0) {
            return new ArrayList<>(0);
        }
        int length = A.length;
        List<Boolean> result = new ArrayList<>(length);
        int index = 0;
        for (int i = 0; i < length; i++) {
            // 每次只保留个位数，通过个位数来判断是否能够被5整除
            index = (index * 2 + A[i]) % 10;
            result.add(index % 5 == 0);
        }
        return result;
    }
}
