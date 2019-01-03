package medium;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i ; j++) {
                if(nums[j] < nums[i]){
                    /**
                     * 两种可能
                     * 1.选择nums[j]作为上升子序列中在加上nums[i],dp[j]+1;
                     * 2.不选择nums[j]作为子序列中的一个,维持原样不变.
                     */
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
