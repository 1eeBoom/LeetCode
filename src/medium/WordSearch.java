package medium;

/**
 *给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(dfs(board,visited,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean dfs(char[][] board,boolean[][] visited,int row,int col,int index,String word)
    {
        //递归调用的终止条件
        //当索引位置位于字符串最后一个字符后面时(即最后一个字符与目标字符串相等已验证)
        if(word.length() == index){
            return true;
        }
        if(row<0||col<0||row >= board.length||col>= board[0].length){
            return false;
        }
        char ch = word.charAt(index);
        //递归继续条件
        if(!visited[row][col]&&ch==board[row][col]){
            //记录当前位置是否已走过
            visited[row][col] = true;
            //若当前字符相等,则向上下左右继续寻找
            boolean rs = dfs(board, visited, row-1, col, index+1, word)||
                         dfs(board, visited, row+1, col, index+1, word)||
                         dfs(board, visited, row, col-1, index+1, word)||
                         dfs(board, visited, row, col+1, index+1, word);
            //清除当前位置记号
            visited[row][col] = false;
            return rs;
        }
        return false;
    }
}
