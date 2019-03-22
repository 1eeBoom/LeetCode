package medium;

/**
 * Created By LeeBoom On 2019/3/22 20:41
 */

/**
 * 题目
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = 0;
        int left = 0;
        int down = n-1;
        int right = n-1;
        for(int i = 1; i <= n*n; ){
            //上
            if(up <= down){
                for(int j = left; j <= right; j++, i++){
                    matrix[up][j] = i;
                }
                up++;
            }
            //右
            if(left <= right){
                for(int j = up; j <= down; j++, i++){
                    matrix[j][right] = i;
                }
                right--;
            }
            //下
            if(up <= down){
                for(int j = right; j >= left; j--, i++){
                    matrix[down][j] = i;
                }
                down --;
            }
            //左
            if(left <= right){
                for(int j = down; j >= up; j--, i++){
                    matrix[j][left] = i;
                }
                left++;
            }
        }
        return matrix;
    }
}
