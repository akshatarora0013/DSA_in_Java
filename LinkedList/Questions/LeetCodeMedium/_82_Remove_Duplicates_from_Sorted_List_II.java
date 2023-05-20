package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class _82_Remove_Duplicates_from_Sorted_List_II {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode prev = new ListNode(0 , head);
            ListNode current = head;
            while(current != null && current.next != null){
                if(current == head && current.val == current.next.val){
                    while(current.next != null && current.val == current.next.val){
                        current = current.next;
                    }
                    current = current.next;
                    head = current;
                    prev.next = head;
                }
                else if(current.val == current.next.val){
                    while(current.next != null && current.val == current.next.val){
                        current = current.next;
                    }
                    current = current.next;
                    prev.next = current;
                }
                else{
                    prev = current;
                    current = current.next;
                }
            }
            return head;
        }
    }
}
