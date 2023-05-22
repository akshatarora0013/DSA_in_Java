package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/valid-perfect-square/

public class _367_Valid_Perfect_Square {
    class Solution {
        public boolean isPerfectSquare(int num) {
            int start = 1;
            int end = num;
            while(start <= end){
                int mid = start + (end - start)/2;
                long square = (long)mid * (long)mid;
                if(square == num){
                    return true;
                }
                else if(square < num){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            return false;
        }
    }
}
