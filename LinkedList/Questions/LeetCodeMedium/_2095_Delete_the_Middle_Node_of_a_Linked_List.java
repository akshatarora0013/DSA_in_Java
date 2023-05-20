package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

public class _2095_Delete_the_Middle_Node_of_a_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode deleteMiddle(ListNode head) {
            if(head == null){
                return head;
            }
            if(head.next == null){
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            int index = 0;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                index++;
            }
            ListNode mid = slow;
            ListNode node = head;
            for(int i = 0; i < index-1; i++){
                node = node.next;
            }
            node.next = mid.next;
            return head;
        }
    }
}
