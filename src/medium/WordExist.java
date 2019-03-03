package medium;

/**
 * Created By LeeBoom On 2019/3/2 18:59
 */

/**
 * 题目：
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
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
 *
 *
 * 思路：
 * 采用深度优先遍历。
 */


public class WordExist {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0)
        {
            return true;
        }
        if(board.length == 0 || board[0].length == 0)
        {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (boolean[] b :
                visited) {
            for (boolean bb :
                    b) {
                bb = false;
            }

        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if(dfs(board, word, visited, i, j, 0)){
                   return true;
               }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
        if(word.length() == index){
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length)
        {
            return false;
        }
        char ch = word.charAt(index);
        if(!visited[row][col] && ch == board[row][col])
        {
            visited[row][col] = true;
            boolean rs = dfs(board,word,visited,row-1,col,index+1)||
                         dfs(board,word,visited,row,col+1,index+1) ||
                         dfs(board,word,visited,row-1,col,index+1) ||
                         dfs(board,word,visited,row,col-1,index+1);
            visited[row][col] = false;
            return rs;
        }
        return false;
    }

}
