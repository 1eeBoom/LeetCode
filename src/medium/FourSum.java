package medium;

/**
 * Created By LeeBoom On 2019/3/19 10:57
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *题目：
 *给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 思路：
 * 和三数之和一样，不同的是需要用二重循环固定住前两个数，对于剩下的两个数使用双指针法处理。
 * 添加链表时，注意去重即可。
 * 可以改进的地方：
 * 在改变前K-1个的指针时，如果移动后和移动前的值一样，那么要继续移动，直到不一样。
 * 即前K-2个再做++等运算时都必须考虑到这个条件。
 *
 *
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length-3; i++)
        {
            for(int j = i+1; j < nums.length-2; j++)
            {
                int start  = j + 1;
                int end = nums.length - 1;
                int sum = nums[i] + nums[j] + nums[start] + nums[end];
                while(start < end)
                {
                    sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum == target)
                    {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        if(!res.contains(list))
                        {
                            res.add(list);
                        }
                        start ++ ;
                        end -- ;
                    }else if(sum < target)
                    {
                        start ++;
                    }else{
                        end --;
                    }
                }
                //  while(nums[j]==nums[j+1] && j<nums.length-2){
                //         j++;
                // }
            }
            //  while(nums[i]==nums[i+1] && i<nums.length-3 ){
            //             i++;
            // }
        }
        return res;
    }
}
