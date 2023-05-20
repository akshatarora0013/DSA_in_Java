package LinkedList.Questions.LeetCodeHard;
import java.util.*;

//  https://leetcode.com/problems/reverse-nodes-in-k-group/

public class _25_Reverse_Node_k_Group {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(k == 1 || head == null){
                return head;
            }
            if(lengthLL(head) == k){
                return reverseList(head);
            }
            ListNode backward = null;
            ListNode current = head;
            ListNode forward = head.next;
            int count = lengthLL(head)/k;
            while(count > 0){
                ListNode last = backward;
                ListNode newEnd = current;
                if(lengthLL(current) < k){
                    current.next = backward;
                    return head;
                }
                for(int i = 0; i < k; i++){
                    current.next = backward;
                    backward = current;
                    current = forward;
                    if(forward != null){
                        forward = forward.next;
                    }
                    if(last != null){
                        last.next = backward;
                    }
                    else{
                        head = backward;
                    }
                    newEnd.next = current;
                }
                backward = newEnd;
                count--;
            }
            return head;
        }
        public int lengthLL(ListNode node){
            int i = 0;
            while(node != null){
                i++;
                node = node.next;
            }
            return i;
        }
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
