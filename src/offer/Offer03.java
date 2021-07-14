package offer;

import java.util.HashSet;
import java.util.Set;

public class Offer03 {
    //找出数组中重复的数字。
//
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表 排序
// 👍 477 👎 0

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 找出重复数字最简单就是维护一个集合，当出现集合中重复的数字时，就可以返回
         * 集合的实现方式有多重，使用 HashMap,Set 等都是很好的选择。
         * 当数字的取值范围不是很大的时候，也可以通过数组下表+元素值的方法来存储数字i出现的次数j nums[i] = j;
         * 当数字的个数不是很多的时候，可以直接排序，然后将元素与前一个或者后一个进行比对，判断是否重复
         *
         * @param nums
         * @return
         */
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i :
                    nums) {
                if (set.contains(i)) {
                    return i;
                } else {
                    set.add(i);
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
