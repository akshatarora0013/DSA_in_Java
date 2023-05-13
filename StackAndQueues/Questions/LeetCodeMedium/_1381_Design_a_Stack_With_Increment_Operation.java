package StackAndQueues.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/design-a-stack-with-increment-operation/description/

public class _1381_Design_a_Stack_With_Increment_Operation {
    class CustomStack {
        int[] data;
        int ptr = 0;
        int max;
        public CustomStack(int maxSize) {
            this.data = new int[maxSize];
            this.max = maxSize;
        }

        public void push(int x) {
            if(ptr == data.length) return;
            data[ptr++] = x;
        }

        public int pop() {
            if(ptr == 0){
                return -1;
            }
            return data[--ptr];
        }

        public void increment(int k, int val) {
            if(k > ptr){
                for(int i = 0 ; i < max; i++){
                    data[i] = data[i] + val;
                }
            }
            else{
                for(int i = 0; i < k ; i++){
                    data[i] = data[i] + val;
                }
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}
