package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *   三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        //排序将正数与负数分开
        Arrays.sort(nums);
        //以所有的负数和0为基准,先固定一个数,找到所有可能的组合
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            //重复的负数不再计算
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(!lists.contains(list)){
                        lists.add(list);
                    }
                    //去除左右重复数字带来的重复组合
                    int leftNum = nums[left];
                    int rightNum = nums[right];
                    while(left<right && nums[left] == leftNum){
                        left++;
                    }
                    while(left<right &&nums[right] == rightNum)
                    {
                        right--;
                    }
                    if(left >= right){
                        break;
                    }
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return lists;
    }
}
