package medium;

/**
 * @author LeeBoom
 * @className NumTrees
 * @description 96. 不同的二叉搜索树
 * @date 2019-04-24 13:53
 **/
public class NumTrees {
    //由于不存在重复元素的可能性，所以对于确定的n个节点，其排列结构可能性也是一定的f(n)
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++) {
            dp[i] = 0;
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
}

