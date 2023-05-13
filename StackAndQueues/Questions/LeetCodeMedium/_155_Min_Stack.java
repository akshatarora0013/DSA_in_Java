package StackAndQueues.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/min-stack/

public class _155_Min_Stack {
    class MinStack {
        PriorityQueue<Integer> pqueue;
        ArrayList<Integer> list;

        public MinStack() {
            pqueue = new PriorityQueue<>();
            list = new ArrayList<>();
        }

        public void push(int val) {
            list.add(val);
            pqueue.offer(val);
        }

        public void pop() {
            int n = list.get(list.size()-1);
            list.remove(list.size()-1);
            pqueue.remove(n);
        }

        public int top() {
            return list.get(list.size()-1);
        }

        public int getMin() {
            return pqueue.peek();
        }
    }
}
