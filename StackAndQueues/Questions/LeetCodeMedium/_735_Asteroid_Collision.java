package StackAndQueues.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/asteroid-collision/description/

public class _735_Asteroid_Collision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            for(int num: asteroids){
                if(num > 0 || stack.isEmpty()){
                    stack.push(num);
                }
                else{
                    while(true){
                        int peek = stack.peek();
                        if(peek < 0){
                            stack.push(num);
                            break;
                        }
                        else if(peek == -num){
                            stack.pop();
                            break;
                        }
                        else if(peek > -num){
                            break;
                        }
                        else{
                            stack.pop();
                            if(stack.isEmpty()){
                                stack.push(num);
                                break;
                            }
                        }
                    }
                }
            }
            int size = stack.size();
            int[] ans = new int[size];
            int index = size-1;
            while(!stack.isEmpty()){
                ans[index] = stack.pop();
                index--;
            }
            return ans;
        }
    }
}
