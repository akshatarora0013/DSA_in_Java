package Arrays.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/lucky-numbers-in-a-matrix/

public class _1380_Lucky_Numbers_in_a_Matrix {
    class Solution {
        public List<Integer> luckyNumbers (int[][] matrix) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < matrix.length; i++){
                int index = 0;
                int min = matrix[i][0];
                for(int j = 1; j < matrix[0].length; j++){
                    if(matrix[i][j] < min){
                        min = matrix[i][j];
                        index = j;
                    }
                }
                int max = matrix[0][index];
                for(int j = 1; j < matrix.length; j++){
                    if(matrix[j][index] > max){
                        max = matrix[j][index];
                    }
                }
                if(min == max){
                    list.add(min);
                }
            }
            return list;
        }
    }
}
