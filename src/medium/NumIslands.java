package medium;

/**
 * Created By LeeBoom On 2019/2/26 19:13
 */

/**
 * 岛屿的个数
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
public class NumIslands {
    public  int numIslands(char[][] grid) {
        if(grid.length == 0)
        {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1')
                {
                    //对数组中每个为'1'的元素调用函数,同时岛屿数加一
                    num++;
                    numIslandsCore(grid, i, j);
                }
            }
        }
        return num;
    }

    /**
     * 将'1'置为'0',并对元素的顺时针方向递归调用该函数.
     * @param grid
     * @param row
     * @param col
     */
    public static void numIslandsCore(char[][] grid, int row, int col)
    {
        //递归结束条件,当前元素为'0'
        if(grid[row][col] == '0')
        {
            return ;
        }
        //将'1'置为'0'
        grid[row][col] = '0';
        //对当前元素顺时针递归调用函数.
        //上
        if(row > 0)
        {
            numIslandsCore(grid, row-1, col);
        }
        //右
        if(col < grid[0].length-1)
        {
            numIslandsCore(grid, row, col+1);
        }
        //下
        if(row < grid.length-1)
        {
            numIslandsCore(grid, row+1, col);
        }
        //左
        if(col > 0)
        {
            numIslandsCore(grid, row, col-1);
        }
        return;
    }
}
