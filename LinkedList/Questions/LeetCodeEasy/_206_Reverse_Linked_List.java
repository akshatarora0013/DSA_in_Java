package LinkedList.Questions.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/reverse-linked-list/

public class _206_Reverse_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null){
                return head;
            }
            ListNode prev = null;
            ListNode current = head;
            ListNode NEXT = head.next;
            while(current != null){
                current.next = prev;
                prev = current;
                current = NEXT;
                if(NEXT != null){
                    NEXT = NEXT.next;
                }
            }
            head = prev;
            return head;
        }
    }
}
