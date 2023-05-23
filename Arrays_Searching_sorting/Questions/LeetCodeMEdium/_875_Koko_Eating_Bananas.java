package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/koko-eating-bananas/description/

public class _875_Koko_Eating_Bananas {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int start = 1;
            int end = Integer.MIN_VALUE;
            for(int i = 0; i < piles.length; i++){
                if(end < piles[i]){
                    end = piles[i];
                }
            }
            int ans = 0;

            while(start <= end){
                int mid = start + (end - start)/2;
                long time = calculate(piles, mid);
                if(time <= h){
                    ans = mid;
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            return ans;
        }
        private long calculate(int[] piles, int mid){
            long sum = 0;
            for(int i = 0; i < piles.length; i++){
                sum += (piles[i]/mid);
                if(piles[i] % mid != 0){
                    sum += 1;
                }
            }
            return sum;
        }
    }
}
