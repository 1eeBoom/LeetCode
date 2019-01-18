package medium;

/**
 *   矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class SetZeroes {
    /**
     * O(M*N)空间
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int elementNum = rowNum*colNum;
        //构建一个M*N的空间用于存储matrix数组中对应元素是否是0
        boolean[] isZero = new boolean[elementNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if(matrix[i][j] == 0){
                    isZero[i*colNum+j] = true;
                }else {
                    isZero[i*colNum+j] = false;
                }
            }
        }
        for (int i = 0; i < elementNum; i++) {
            if(isZero[i]){
                //得到数值为0的元素所在的行号列号
                int row = i/colNum;
                int col = i%colNum;
                //将所在行和列的元素都置为0,由于依托的条件是isZero数组,所以对判断产生影响
                for (int j = 0; j < colNum; j++) {
                    matrix[row][j] = 0;
                }
                for (int j = 0; j < rowNum; j++) {
                    matrix[j][col] = 0;

                }
            }
        }
    }

    /**
     * O(M+N)空间
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        //分别用M和N的空间用来存储需要置0的行和列
        boolean[] rowIsZero = new boolean[rowNum];
        boolean[] colIsZero = new boolean[colNum];
        for (int i = 0; i < rowNum ; i++) {
            rowIsZero[i] = false;
        }
        for (int i = 0; i < colNum ; i++) {
            colIsZero[i] = false;
        }
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if(matrix[i][j] == 0){
                   rowIsZero[i] = true;
                   colIsZero[j] = true;
                }
            }
        }
        //将需要置0的行和列中的元素分别置0,由于依托的是额外的数组,所以置0的结果不会对原结果产生影响.
        for (int i = 0; i < rowNum ; i++) {
            if(rowIsZero[i]){
                for (int j = 0; j < colNum ; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < colNum ; i++) {
            if(colIsZero[i]){
                for (int j = 0; j < rowNum ; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    /**
     * O(C)空间
     * @param matrix
     */
    public  void setZeroes2(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean existZero = false;
        int row = -1;
        int col = -1;
        //得到第一个为0的元素,并记录下来该元素的下标.
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if(matrix[i][j] == 0){
                   existZero = true;
                   row = i;
                   col = j;
                   break;
                }
            }
        }
        //判断是否存在有为0的元素
        if(!existZero){
            return ;
        }
        //将找到的第一个为0的元素所在的行和列作为M+N-1的数组 用于记录需要置0的行和列
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if(matrix[i][j] == 0){
                   matrix[i][col] = 0;
                   matrix[row][j] = 0;
                }
            }
        }
        //由于是使用 matrix 本身数组记录 需要置0的行列,所以对于第一个为0的元素的所在行和列需要最后再处理
        //否则会导致整个数组为0
        for (int i = 0; i < colNum ; i++) {
            if(i == col){
                continue;
            }
            if(matrix[row][i] == 0 ){
                for (int j = 0; j < rowNum ; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < rowNum ; i++) {
            if(i == row){
                continue;
            }
            if(matrix[i][col] == 0){
                for (int j = 0; j < colNum ; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        //对第一个为0的元素所在行列进行置0
        for (int i = 0; i <rowNum ; i++) {
            matrix[i][col] = 0;
        }
        for (int i = 0; i <colNum ; i++) {
            matrix[row][i] = 0;
        }

    }
}