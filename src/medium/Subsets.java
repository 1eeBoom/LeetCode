package medium;

/**
 * Created By LeeBoom On 2019/3/2 14:21
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：
 *
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 思路：
 * 数学方法，给定一个长度为n的集合，那么他的非空子集为2^n-1。如果包含空集则为2^n。
 * 题目中说数组不包含重复元素，则不需要考虑去重。
 * 每个元素都有选或者不选两个操作，二进制的'0'代表不选，二进制的'1'代表选
 * 举例：
 * [1,2,3] = 111 = 7
 * [3] = 100 = 4
 * 这样通过0-2^n-1与数字1相与，然后移位继续相与，就可以得到所有可能子集。
 */
public class Subsets {
    public  List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, new LinkedList<>(), 0, nums);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list,int start, int[] nums) {
        if(start == nums.length) {
            List<Integer> temp = new LinkedList<>(list);
            // if(!res.contains(temp)) {
            res.add(temp);
            // }
        } else {
            //选择当前nums[i]加入List中
            list.add(nums[start]);
            dfs(res, list, start+1, nums);
            list.remove(list.size() - 1);
            //不选择当前的nums[i]加入到List中
            dfs(res, list, start+1, nums);
        }
    }
}
