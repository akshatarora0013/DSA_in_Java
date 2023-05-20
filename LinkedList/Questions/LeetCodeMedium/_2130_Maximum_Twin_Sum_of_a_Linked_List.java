package LinkedList.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

public class _2130_Maximum_Twin_Sum_of_a_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public int pairSum(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode nextNode = null;
            ListNode prev = null;
            while(slow != null){
                nextNode = slow.next;
                slow.next = prev;
                prev = slow;
                slow = nextNode;
            }

            ListNode start = head;
            int max = 0;
            while(prev != null){
                max = Math.max(max, start.val + prev.val);
                prev = prev.next;
                start = start.next;
            }

            return max;
        }
    }
}
