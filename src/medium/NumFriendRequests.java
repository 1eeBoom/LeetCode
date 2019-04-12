package medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author LeeBoom
 * @className NumFriendRequests
 * @description 825. 适龄的朋友
 * @date 2019-04-12 22:57
 **/

public class NumFriendRequests {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < ages.length; i++) {
            if (!hashmap.containsKey(ages[i])) {
                hashmap.put(ages[i], 1);
            } else {
                hashmap.put(ages[i], hashmap.get(ages[i]) + 1);
            }
        }
        int count = 0;
        for (int a : hashmap.keySet()) {
            for (int b : hashmap.keySet()) {
                if (!((float) b <= 0.5 * a + 7 || b > a)) {
                    if (a == b) {
                        count += hashmap.get(a) * (hashmap.get(a) - 1);
                    } else {
                        count += hashmap.get(a) * hashmap.get(b);
                    }
                }
            }
        }
        return count;
    }
}
