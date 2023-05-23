package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

//   https://leetcode.com/problems/reach-a-number/description/

public class _754_Reach_a_Number {
    class Solution {
        public int reachNumber(int target) {
            if(target < 0){
                target *= -1;
            }

            int start = 1;
            int end = target;
            int numMoves = 0;
            long pos = 0;

            while(start <= end){
                int mid = start + (end - start)/2;
                long distance = (long)mid*(mid+1)/2;
                if(distance >= target){
                    pos = distance;
                    numMoves = mid;
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            int difference = (int)(pos - target);
            if(difference % 2 != 0){
                if((numMoves+1) % 2 != 0){
                    numMoves += 1;
                }
                else{
                    numMoves += 2;
                }
            }

            return numMoves;
        }
    }
}
