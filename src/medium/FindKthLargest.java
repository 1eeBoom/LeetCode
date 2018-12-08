package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class FindKthLargest {
    public static void main(String[] args){
        int[] nums = {2,3,6,5,1,4};
        findKthLargest(nums,1);
    }
    public static int findKthLargest(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        fastSort(nums,0,nums.length-1);
        for(int i : nums){
            System.out.println(i);
        }
        for(int i = nums.length-1; i >= 0; i--){
            int j = nums[i];
            if(!set.contains(j)){
                set.add(j);
                if(set.size()==k){
                    return j;
                }
            }

        }
        return 0;

    }
    public static void fastSort(int[] nums, int left,int right){

        if(left>=right){
            return ;
        }
        int flag = nums[left];
        int i = left;
        int j = right;
        while(left<right){
            while(nums[right]>=flag && left<right){
                right--;
            }
            if(left < right){
                nums[left] = nums[right];
            }
            while(nums[left] <= flag && left<right)
            {
                left++;
            }
            if(left < right){
                nums[right] = nums[left];
            }
        }
        nums[left] = flag;
        fastSort(nums,i,left-1);
        fastSort(nums,left+1,j);
    }
}
