package StackAndQueues.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/implement-queue-using-stacks/description/

public class _232_Implement_Queue_using_Stacks {
    class MyQueue {
        Stack<Integer> first;
        Stack<Integer> second;


        public MyQueue() {
            first = new Stack<>();
            second = new Stack<>();
        }

        public void push(int x) {
            first.push(x);
        }

        public int pop() {
            while(!first.empty()){
                second.push(first.pop());
            }
            int num = second.pop();
            while(!second.empty()){
                first.push(second.pop());
            }
            return num;
        }

        public int peek() {
            while(!first.empty()){
                second.push(first.pop());
            }
            int num = second.peek();
            while(!second.empty()){
                first.push(second.pop());
            }
            return num;
        }

        public boolean empty() {
            if(first.empty()){
                return true;
            }
            return false;
        }
    }
}
