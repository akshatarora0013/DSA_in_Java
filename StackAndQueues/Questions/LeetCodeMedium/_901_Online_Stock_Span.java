package StackAndQueues.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/online-stock-span/description/

public class _901_Online_Stock_Span {
    class StockSpanner {
        Stack<int[]> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price){
            int ans = 1;
            while(!stack.isEmpty() && stack.peek()[0] <= price){
                ans += stack.pop()[1];
            }
            stack.push(new int[] {price, ans});
            return ans;
        }
    }
}
