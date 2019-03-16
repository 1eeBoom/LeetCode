package medium;

import java.util.*;

/**
 * Created By LeeBoom On 2019/3/16 19:29
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Set<Integer> exclude = new HashSet<>();
        backup(res,list,candidates,target,0,exclude);
        return res;
    }
    public void backup(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int start, Set<Integer> exclude)
    {
        //出口
        if(target < 0){
            return ;
        }else if(target == 0 && !res.contains(list)){
            res.add(new LinkedList(list));
        }else{
            for(int i = start; i < nums.length; i++)
            {
                if(!exclude.contains(i))
                {
                    //如果当前递归过程的处理参数符合要求，则执行相关赋值或其它操作
                    exclude.add(i);
                    list.add(nums[i]);
                    //然后转入下一次递归
                    backup(res,list,nums,target - nums[i],i,exclude);
                    //如果下一次递归不能找到出口，则把之前相关赋值或其它操作重置为初始状态
                    list.remove(list.size() - 1);
                    exclude.remove(i);
                }
            }
        }

    }
}
