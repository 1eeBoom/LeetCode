package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = res[1] = -1;
        if(nums.length == 0){
            return res;
        }
        //二分查找法
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        //一定要left<=right 不然当left = right时，mid无法更新；
        while(left <= right)
        {
            mid = (left + right) / 2;
            if(nums[mid] == target){
                break;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(nums[mid] == target)
        {
            int pre = mid;
            int next = mid;
            while(pre >= 0 && nums[pre] == target)
            {
                pre --;
            }
            pre ++;
            while(next <= nums.length-1 && nums[next] == target)
            {
                next ++;
            }
            next --;
            res[0] = pre;
            res[1] = next;
        }
        return res;
    }
}
