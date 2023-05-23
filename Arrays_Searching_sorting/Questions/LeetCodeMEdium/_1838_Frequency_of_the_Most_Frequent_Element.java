package Arrays_Searching_sorting.Questions.LeetCodeMEdium;
import java.util.*;

//  https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/

public class _1838_Frequency_of_the_Most_Frequent_Element {
    class Solution {
        public int maxFrequency(int[] nums, int k) {
            Arrays.sort(nums);
            int start = 0;
            int preSum = 0;
            int total = 1;
            for (int i = 0; i < nums.length; i++) {
                int length = i - start + 1;
                int product = nums[i] * length;
                preSum += nums[i];
                while (product - preSum > k) {
                    preSum -= nums[start++];
                    length--;
                    product = nums[i] * length;
                }
                total = Math.max(total, length);
            }

            return total;
        }
    }
}
