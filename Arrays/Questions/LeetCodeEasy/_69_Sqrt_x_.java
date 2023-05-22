package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/sqrtx/

public class _69_Sqrt_x_ {
    class Solution {
        public int mySqrt(int x) {
            int start = 1;
            int end = x;
            int result = 0;
            while(start <= end){
                int mid = start + (end - start)/2;
                long square = (long)mid * (long)mid;
                if(square == x){
                    return mid;
                }
                else if(square < x){
                    result = mid;
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            return result;
        }
    }
}
