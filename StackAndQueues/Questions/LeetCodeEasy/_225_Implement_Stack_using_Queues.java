package StackAndQueues.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/implement-stack-using-queues/description/

public class _225_Implement_Stack_using_Queues {
    class MyStack {
        Queue<Integer> queue;
        Queue<Integer> queue2;

        public MyStack() {
            queue = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            while(queue.size() != 1){
                queue2.add(queue.remove());
            }
            int last = queue.remove();
            while(!queue2.isEmpty()){
                queue.add(queue2.remove());
            }
            return last;
        }

        public int top() {
            while(queue.size() != 1){
                queue2.add(queue.remove());
            }
            int last = queue.peek();
            queue2.add(queue.remove());
            while(!queue2.isEmpty()){
                queue.add(queue2.remove());
            }
            return last;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
