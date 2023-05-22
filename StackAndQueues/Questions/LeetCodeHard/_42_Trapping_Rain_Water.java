package StackAndQueues.Questions.LeetCodeHard;
import java.util.*;

//  https://leetcode.com/problems/trapping-rain-water/description/

public class _42_Trapping_Rain_Water {
    class Solution {
        public int trap(int[] height) {
            int current = 0;
            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            while(current < height.length){
                while(!stack.isEmpty() && height[current] > height[stack.peek()]){
                    int top = stack.pop();
                    if(stack.isEmpty()){
                        break;
                    }
                    int distance = current-stack.peek()-1;
                    int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];

                    ans += distance * boundedHeight;
                }
                stack.push(current++);
            }
            return ans;
        }
    }
}
