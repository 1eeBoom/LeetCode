package medium;

/**
 * Created By LeeBoom On 2019/3/24 15:50
 */

/**
 * 题目：
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        int[][] dp = new int[rowNum][colNum];
        //特殊情况，当矩阵为[[0]]时，结果为1
        //矩阵为[[1]]时，结果为0；
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : -1;
        //到达边上的格子的方法只有1种，如果格子上出现障碍，则后面的格子都无法到达。
        for(int i = 1; i < colNum; i++){
            if(obstacleGrid[0][i] != 1 && dp[0][i-1] != -1){
                dp[0][i] =  1;
            } else {
                dp[0][i] = -1;
            }
        }
        //同上
        for(int i = 1; i < rowNum; i++){
            if(obstacleGrid[i][0] != 1 && dp[i-1][0] != -1){
                dp[i][0] =  1;
            } else {
                dp[i][0] = -1;
            }
        }

        //从matrix[1][1]开始
        for(int i = 1; i < rowNum; i++){
            for(int j = 1; j < colNum; j++){
                if(obstacleGrid[i][j] != 1){
                    //如果当前元素不为1，即当前格子上没有障碍，就对正上方和左方的格子进行判断
                    /*
                     * 一共四种情况
                     * 1.上方和左方的格子都没有障碍物，那么当前格子的可达到方法为两格子可到达路径之和
                     * 2./3. 如果上方/左方的格子有障碍物，那么当前格子的可到达路径为左方/上方的可到                      * 达路径
                     * 4. 上方和左方的格子都有障碍物，那么当前格子不可达。
                     */
                    if(dp[i-1][j] != -1 && dp[i][j-1] != -1){
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    } else if(dp[i-1][j] != -1 && dp[i][j-1] == -1) {
                        dp[i][j] = dp[i-1][j] ;
                    } else if(dp[i][j-1] != -1  && dp[i-1][j] == -1 ) {
                        dp[i][j] = dp[i][j-1] ;
                    } else {
                        dp[i][j] = -1;
                    }
                }else{
                    dp[i][j] = -1;
                }
            }
        }
        if(dp[rowNum-1][colNum-1] == -1){
            //如果当前元素为1，即当前格子上有障碍，那么当前格子不可达。
            return 0;
        }
        return dp[rowNum-1][colNum-1];
    }
}
