package LinkedList.Questions.LeetCodeMedium;
import java.util.*;

//   https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/

public class _2058_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            List<Integer> index = new ArrayList<>();
            int idx = 2;
            ListNode prev = head;
            ListNode temp = head.next;
            while(temp.next != null){
                if((temp.val > prev.val && temp.val > temp.next.val) || (temp.val < prev.val && temp.val < temp.next.val)){
                    index.add(idx);
                }
                idx++;
                temp = temp.next;
                prev = prev.next;
            }
            if(index.size() <= 1){
                return new int[] {-1, -1};
            }
            int max = index.get(index.size()-1) - index.get(0);
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < index.size(); i++){
                if(index.get(i) - index.get(i-1) < min){
                    min = index.get(i) - index.get(i-1);
                }
            }
            return new int[] {min, max};
        }
    }
}
