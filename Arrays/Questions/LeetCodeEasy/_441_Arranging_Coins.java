package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/arranging-coins/description/

public class _441_Arranging_Coins {
    class Solution {
        public int arrangeCoins(int n) {
            long start = 0;
            long end = n;

            while(start <= end){
                long mid = start +(end - start)/2;
                long compare = (mid * (mid+1))/2;
                if(compare == n){
                    return (int)mid;
                }
                else if(compare < n){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            return (int)end;
        }
    }
}
