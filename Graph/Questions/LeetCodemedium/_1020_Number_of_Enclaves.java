package Graph.Questions.LeetCodemedium;

//   https://leetcode.com/problems/number-of-enclaves/description/

public class _1020_Number_of_Enclaves {
    class Solution {
        public int numEnclaves(int[][] board) {
            int m = board.length;
            int n = board[0].length;

            for(int i = 0; i < n; i++){
                if(board[0][i] == 1){
                    board[0][i] = 0;
                    dfs(0, i, board);
                }
                if(board[m-1][i] == 1){
                    board[m-1][i] = 0;
                    dfs(m-1, i, board);
                }
            }

            for(int i = 0; i < m; i++){
                if(board[i][0] == 1){
                    board[i][0] = 0;
                    dfs(i, 0, board);
                }
                if(board[i][n-1] == 1){
                    board[i][n-1] = 0;
                    dfs(i, n-1, board);
                }
            }
            int count = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 1){
                        count++;
                    }
                }
            }
            return count;
        }
        int[] delRow = {1, 0, -1, 0};
        int[] delCol = {0, 1, 0, -1};
        void dfs(int row, int col, int[][] board){
            for(int i = 0; i < 4; i++){
                int newRow = row+delRow[i];
                int newCol = col+delCol[i];

                if(newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length && board[newRow][newCol] == 1){
                    board[newRow][newCol] = 0;
                    dfs(newRow, newCol, board);
                }
            }
        }
    }
}
