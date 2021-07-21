package offer;

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。
//
//
//
// 示例:
//
// 现有矩阵 matrix 如下：
//
//
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//
//
// 给定 target = 5，返回 true。
//
// 给定 target = 20，返回 false。
//
//
//
// 限制：
//
// 0 <= n <= 1000
//
// 0 <= m <= 1000
//
//
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
// Related Topics 数组 二分查找 分治 矩阵
// 👍 390 👎 0
//		解答成功:
//		执行耗时:0 ms,击败了100.00% 的Java用户
//		内存消耗:44.2 MB,击败了38.55% 的Java用户

public class Offer04 {
    /**
     * 如题，二维矩阵的元素规律为从左到右元素变大，从上到下元素变大
     * 该规律下，右上角的元素就会变得尤其特殊，不仅是该行最大的元素，也是该列最小的元素。
     * 从对角元素出发，将寻找的target与该数字matrix[i][j]进行比对
     * 如果target 大于 matrix[i][j]，则代表该行不存在target，i++
     * 如果target 小于 matrix[i][j], 则代表该列不存在target，j--
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix ==null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length-1;
        int colNum = matrix[0].length-1;
        int i = 0;
        int j = colNum;
        while (i <= rowNum && j >=0){
            if (matrix[i][j] == target) {
                return true;
            }else if(matrix[i][j] > target) {
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
