package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created By LeeBoom On 2019/3/22 20:40
 */

/**
 * 题目：
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int rowNum = matrix.length;
        if(rowNum == 0){
            return list;
        }
        int colNum = matrix[0].length;
        int up = 0;
        int down = rowNum - 1;
        int left = 0;
        int right = colNum - 1;
        while((left  <= right) && (up  <= down)){
            if(up  <= down){
                for(int i = left; i <= right; i++){
                    list.add(matrix[up][i]);
                }

                up ++ ;
            }
            if(left  <= right){
                for(int i = up; i <= down; i++){
                    list.add(matrix[i][right]);
                }

                right -- ;
            }
            if(up  <= down){
                for(int i = right; i >= left; i--){
                    list.add(matrix[down][i]);
                }

                down --;
            }
            if(left  <= right){
                for(int i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                }

                left ++ ;
            }
        }

        return list;
    }
}
