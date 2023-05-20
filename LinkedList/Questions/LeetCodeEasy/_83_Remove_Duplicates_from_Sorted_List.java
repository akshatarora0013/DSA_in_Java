package LinkedList.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class _83_Remove_Duplicates_from_Sorted_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode node = new ListNode();
            node = head;
            if(head == null){
                return head;
            }
            while(node.next != null){
                if(node.val == node.next.val){
                    node.next = node.next.next;
                }
                else{
                    node = node.next;
                }
            }
            return head;
        }
    }
}
