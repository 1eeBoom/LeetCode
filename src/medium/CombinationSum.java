package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By LeeBoom On 2019/3/16 19:28
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //先将数组排序
        Arrays.sort(candidates);

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if(candidates.length == 0)
        {
            return res;
        }
        backUp(res, list, target, candidates, 0);
        return res;

    }
    public void backUp(List<List<Integer>> res ,List<Integer> list, int target, int[] candidates, int start)
    {
        //函数出口
        if(target < 0)
        {
            return;
        }else if(target == 0)
        {
            //结果一定是要有一个全局参数来保存,这个全局参数不会随着每一次的递归操作而随时改变，它只是用来保存每一次递归操作成功时的结果
            res.add(new ArrayList<>(list));
        }else{
            //从start开始，是为了去除重复。如果重零开始则会出现[[2,2,3],[2,3,2],[3,2,2],[7]] 这样的数组
            for(int i = start; i < candidates.length; i++)
            {
                //如果当前递归过程的处理参数符合要求，则执行相关赋值或其它操作，然后转入下一次递归，如果下一次递归不能找到出口，则把之前相关赋值或其它操作重置为初始状态

                list.add(candidates[i]);
                //target - candidates[i] 是为了不破坏当前值，函数就能回溯。
                backUp(res, list, target - candidates[i], candidates, i);
                //回退后，将状态还原。
                list.remove(list.size()-1);
            }
        }
    }
}
