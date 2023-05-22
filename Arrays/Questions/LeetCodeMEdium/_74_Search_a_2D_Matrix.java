package Arrays.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/search-a-2d-matrix/description/

public class _74_Search_a_2D_Matrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix.length == 1){
                return binarySearch(0, 0, matrix[0].length-1, matrix, target);
            }
            int cmid = (matrix[0].length-1)/2;
            int rstart = 0;
            int rend = matrix.length-1;
            while(rstart < rend - 1){
                int rmid = rstart+ (rend-rstart)/2;
                if(matrix[rmid][cmid] == target){
                    return true;
                }
                else if(matrix[rmid][cmid] < target){
                    rstart = rmid;
                }
                else{
                    rend = rmid;
                }
            }
            if(target == matrix[rstart][cmid] || target == matrix[rend][cmid]){
                return true;
            }
            if(binarySearch(rstart, 0, cmid-1, matrix, target) || binarySearch(rstart, cmid+1, matrix[0].length-1, matrix, target) || binarySearch(rend, 0, cmid-1, matrix, target) || binarySearch(rend, cmid+1, matrix[0].length-1, matrix, target)){
                return true;
            }
            return false;
        }
        private boolean binarySearch(int row, int cStart, int cEnd, int[][] matrix, int target){
            while(cStart <= cEnd){
                int mid = cStart + (cEnd-cStart)/2;
                if(matrix[row][mid] == target){
                    return true;
                }
                else if(matrix[row][mid] < target){
                    cStart = mid+1;
                }
                else{
                    cEnd = mid-1;
                }
            }
            return false;
        }
    }
}
