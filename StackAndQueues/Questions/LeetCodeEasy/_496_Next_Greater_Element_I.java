package StackAndQueues.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/next-greater-element-i/

public class _496_Next_Greater_Element_I {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> stack = new Stack<>();
            HashMap<Integer , Integer> hm = new HashMap<>();
            hm.put(nums2[nums2.length-1] , -1);
            stack.push(nums2[nums2.length-1]);

            for(int i = nums2.length-2; i>=0; i--){
                while(!stack.isEmpty() && stack.peek() < nums2[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    hm.put(nums2[i] , -1);
                }
                else{
                    hm.put(nums2[i] , stack.peek());
                }
                stack.push(nums2[i]);
            }
            for(int i = 0; i < nums1.length; i++){
                nums1[i] = hm.get(nums1[i]);
            }
            return nums1;
        }
    }
}
