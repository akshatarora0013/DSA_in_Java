package Graph.Code;

import java.util.*;

//   https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-floyd-warshall

public class FloydWarshal {
    class Solution {
        public void shortest_distance(int[][] matrix)
        {
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix.length; j++){
                    if(matrix[i][j] == -1){
                        matrix[i][j] = (int)(1e9);
                    }
                    if(i == j){
                        matrix[i][j] = 0;
                    }
                }
            }
            for(int k = 0; k < matrix.length; k++){
                for(int i = 0; i < matrix.length; i++){
                    for(int j = 0; j < matrix.length; j++){
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix.length; j++){
                    if(matrix[i][j] == (int)(1e9)){
                        matrix[i][j] = -1;
                    }
                }
            }
        }
    }
}
