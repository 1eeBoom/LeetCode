package medium;

/**
 * Created By LeeBoom On 2019/3/15 14:17
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null)
        {
            return 0;
        }
        //创建一个二维数组记录每个位置的最小路径dp[n][m];
        int[][] dp = new int[grid.length][grid[0].length];
        //先将数组的第一列和第一行的dp计算出来
        //注意：在动态规划问题中第1行和第1列需要手动求出，需要根据问题的要求进行求解，一般第1行和第1列的求解很简单。
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid[0].length; i++)
        {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < grid.length; i++)
        {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        //从上到下，从左到右，通过二重循环求出任意dp[i][j]的结果填充到dp[][]中
        for(int i = 1; i < grid.length; i++)
        {
            for(int j = 1; j < grid[0].length; j++)
            {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
