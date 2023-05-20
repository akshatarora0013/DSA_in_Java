package LinkedList.Questions.LeetCodeMedium;

//   https://leetcode.com/problems/swap-nodes-in-pairs/

public class _24_Swap_Nodes_in_Pairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

     class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode prev = head;
            ListNode current = head.next;
            while(current != null){
                int temp = prev.val;
                prev.val = current.val;
                current.val = temp;
                prev = current;
                current = current.next;
                if(current != null){
                    prev = current;
                    current = current.next;
                }
            }
            return head;
        }
    }
}
