package medium;

/**
 * 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        //先将两个数字的序列确定下来
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            //找到第三个数
            if(nums[i]>num2)
                return true;
            //如果遇到比第一个数小的则更新,
            //后面即使再次更新也没关系,因为num2的存在表示前面已经有一个长度为2的递增序列
            if(nums[i]<num1)
                num1=nums[i];
            //找到长度为2的序列
            if(nums[i]>num1&&nums[i]<num2)
                num2=nums[i];
        }
        return false;
    }
}
