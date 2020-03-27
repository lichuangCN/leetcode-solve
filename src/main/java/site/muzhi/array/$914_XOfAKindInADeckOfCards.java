package site.muzhi.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lichuang
 * @date: 2020/03/27
 * @description:
 */

public class $914_XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int d : deck) {
            if (hashMap.containsKey(d)) {
                hashMap.put(d, hashMap.get(d) + 1);
            } else {
                hashMap.put(d, 1);
            }
        }
        // 公约数
        int x = 0;
        for (Integer value : hashMap.values()) {
            x = gcd(x, value);
        }
        return x >= 2;
    }

    public int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
}
