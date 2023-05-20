package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

public class _19_Remove_Nth_Node_From_End_of_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = head;
            int length = 0;
            while (node != null){
                length++;
                node = node.next;
            }
            if(length == n){
                head = head.next;
                return head;
            }
            if(n == 1){
                ListNode temp = head;
                for(int i = 1; i < length - n; i++){
                    temp = temp.next;
                }
                temp.next = null;
                return head;
            }
            ListNode temp = head;
            for(int i = 0; i < length - n; i++){
                temp = temp.next;
            }
            ListNode nexttemp = temp.next;
            temp.val = nexttemp.val;
            temp.next = nexttemp.next;
            nexttemp.next = null;
            return head;
        }
    }
}
