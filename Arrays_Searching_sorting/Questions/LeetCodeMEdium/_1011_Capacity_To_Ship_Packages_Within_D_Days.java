package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

//  https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

public class _1011_Capacity_To_Ship_Packages_Within_D_Days {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int start = 0;
            int end = 0;
            for(int i = 0; i < weights.length; i++){
                start = Math.max(start , weights[i]);
                end += weights[i];
            }

            while(start < end){
                int mid = start + (end - start)/2;
                int sum = 0;
                int partition = 1;

                for(int i = 0; i < weights.length; i++){
                    sum += weights[i];
                    if(sum > mid){
                        partition++;
                        sum = weights[i];
                    }
                }

                if(partition <= days){
                    end = mid;
                }
                else{
                    start = mid+1;
                }
            }
            return start;
        }
    }
}
