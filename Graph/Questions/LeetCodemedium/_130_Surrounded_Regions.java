package Graph.Questions.LeetCodemedium;

import java.util.*;

//  https://leetcode.com/problems/surrounded-regions/description/

public class _130_Surrounded_Regions {
    class Solution {
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            boolean[][] processed = new boolean[m][n];

            for(int i = 0; i < n; i++){
                if(board[0][i] == 'O'){
                    if(!processed[0][i]){
                        processed[0][i] = true;
                        fillingMap(0, i, board, processed);
                    }
                }
                if(board[m-1][i] == 'O'){
                    if(!processed[m-1][i]){
                        processed[m-1][i] = true;
                        fillingMap(m-1, i, board, processed);
                    }
                }
            }

            for(int i = 0; i < m; i++){
                if(board[i][0] == 'O'){
                    if(!processed[i][0]){
                        processed[i][0] = true;
                        fillingMap(i, 0, board, processed);
                    }
                }
                if(board[i][n-1] == 'O'){
                    if(!processed[i][n-1]){
                        processed[i][n-1] = true;
                        fillingMap(i, n-1, board, processed);
                    }
                }
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 'O' && !processed[i][j]){
                        board[i][j] = 'X';
                    }
                }
            }

        }
        public void fillingMap(int i, int j, char[][] board, boolean[][] processed){
            if(j-1 >= 0 && board[i][j-1] == 'O'){
                if(!processed[i][j-1]){
                    processed[i][j-1] = true;
                    fillingMap(i, j-1, board, processed);
                }
            }
            if(j+1 < board[0].length && board[i][j+1] == 'O'){
                if(!processed[i][j+1]){
                    processed[i][j+1] = true;
                    fillingMap(i, j+1, board, processed);
                }
            }
            if(i-1 >= 0 && board[i-1][j] == 'O'){
                if(!processed[i-1][j]){
                    processed[i-1][j] = true;
                    fillingMap(i-1, j, board, processed);
                }
            }
            if(i+1 < board.length && board[i+1][j] == 'O'){
                if(!processed[i+1][j]){
                    processed[i+1][j] = true;
                    fillingMap(i+1, j, board, processed);
                }
            }
        }
    }
}
