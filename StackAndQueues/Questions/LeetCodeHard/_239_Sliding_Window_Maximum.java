package StackAndQueues.Questions.LeetCodeHard;
import java.util.*;

//   https://leetcode.com/problems/sliding-window-maximum/description/

public class _239_Sliding_Window_Maximum {
    class Solution{
        public int[] maxSlidingWindow(int[] nums, int k){
            if(nums.length == 0 || k == 0){
                return new int[0];
            }
            int[] result = new int[nums.length-k+1];
            Deque<Integer> win = new ArrayDeque<>();
            for(int i = 0; i < nums.length; i++){
                while(win.size() > 0 && win.peekFirst() <= i-k){
                    win.pollFirst();
                }
                while(win.size() > 0 && nums[win.peekLast()] < nums[i]){
                    win.pollLast();
                }
                win.offerLast(i);
                if(i >= k-1){
                    result[i-k+1] = nums[win.peekFirst()];
                }
            }
            return result;
        }
    }
}
