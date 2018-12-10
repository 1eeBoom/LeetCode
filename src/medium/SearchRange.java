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
    public static int[] searchRange(int[] nums, int target) {
        int[] ret = {-1,-1};
        int len = nums.length;
        int left = 0;
        int right = len-1;
        if(len==1&&nums[0]==target){
            int[] ret1 = {0,0};
            return ret1;
        }
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid;
                right = mid;
                while(left>0&&nums[left-1]==target){
                    left--;
                }
                while(right<len-1&&nums[right+1]==target){
                    right++;
                }
                ret[0] = left;
                ret[1] = right;
                return ret;
            }
        }
        return ret;
    }
    public static void main(String[] args){
        int[] nums ={1,4};
        searchRange(nums,4);
    }
}
