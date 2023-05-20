package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/reverse-linked-list-ii/

public class _92_Reverse_Linked_List_II {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left == right){
                return head;
            }
            ListNode prev = null;
            ListNode current = head;
            for(int i = 1; current != null && i < left; i++){
                prev = current;
                current = current.next;
            }
            ListNode last = prev;
            ListNode newend = current;
            ListNode NEXT = current.next;
            for(int i = 0; current != null && i < right-left+1; i++){
                current.next = prev;
                prev = current;
                current = NEXT;
                if(NEXT != null){
                    NEXT = NEXT.next;
                }
            }
            if(last != null){
                last.next = prev;
            }
            else{
                head = prev;
            }
            newend.next = current;
            return head;
        }
    }
}
