package medium;

/**
 * Created By LeeBoom On 2019/3/18 21:51
 */

import java.util.Arrays;

/**
 * 题目
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 思路：
 * 1.先将数组排序
 * 2.从头开始，先固定一个元素
 * 3.对剩下的元素，使用双指针法，从头和尾开始，向中间靠近，直到start >= end
 * 4.对于每次得到的sum 和 target之间的差值和差值的最小值 进行对比，如果当前的更小，则记录下对应的sum；
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = nums[0]+nums[1]+nums[2];
        for(int i = 0; i < nums.length-1; i++)
        {
            int start = i + 1;
            int end = nums.length - 1;
            int sum = nums[i] + nums[start] + nums[end];
            while(start < end)
            {
                sum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(sum - target);
                res = diff < min ? sum : res;
                min = diff < min ? diff : min;
                if(sum > target)
                {
                    end --;
                }else{
                    start ++;
                }

            }
        }
        return res;
    }
}
