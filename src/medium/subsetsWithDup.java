package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LeeBoom
 * @className subsetsWithDup
 * @description 90. 子集 II
 * @date 2019-04-22 23:42
 **/
public class subsetsWithDup {
    public  List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, new LinkedList<>(), 0, nums);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list,int start, int[] nums) {
        if(start == nums.length) {
            List<Integer> temp = new LinkedList<>(list);
             if(!res.contains(temp)) {
            res.add(temp);
             }
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
