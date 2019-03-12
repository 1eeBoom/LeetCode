package medium;

/**
 * Created By LeeBoom On 2019/3/12 20:50
 */

/**
 * 题目：
 * 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 思路：
 * 动态规划
 * 假设位置i(0≤i≤A.length)i(0≤i≤A.length)能够跳跃的最大长度为dp[i]。
 * 如果前一个位置能够跳跃的最大长度大于等于当前位置的下标，那么当前位置跳跃的最大长度为 max(从当前位置起跳的最大长度，前一个位置跳跃的最大长度）。
 * 如果前一个位置不能够跳到当前位置，那么当前位置的跳跃最大长度为0。
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if(nums.length == 0)
        {
            return false;
        }
        int end = nums.length - 1;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length-1 <= dp[0])
        {
            return true;
        }
        for(int i = 1; i < end; i++)
        {
            if(dp[i-1] >= i)
            {
                dp[i] = Math.max(i + nums[i],dp[i-1]);
                if(dp[i] >= end)
                {
                    return true;
                }
            }else{
                dp[i] = 0;
            }
        }
        return false;
    }
}
