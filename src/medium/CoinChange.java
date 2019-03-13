package medium;

import java.util.Arrays;

/**
 * Created By LeeBoom On 2019/3/13 15:33
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount==0||coins.length<=0)
        {
            return 0;
        }
        /**
         * 数据记录当金额为amount时，最少能凑成的硬币数
         */
        int[] dp = new int[amount+1];
        /**
         * 令数组中的每个元素为amount+1,即硬币数可能最大值+1
         */
        Arrays.fill(dp,amount+1);
        Arrays.sort(coins);
        //对于每个金额计算最小的硬币数
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(i-coins[j]==0)
                {
                    dp[i]=1;
                }
                else if(i-coins[j]>0){
                    //当金额大于硬币数字时，进行比较
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        //如果数组没有更新，则代表无解。
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
