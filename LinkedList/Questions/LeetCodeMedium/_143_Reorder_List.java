package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/reorder-list/

public class _143_Reorder_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if(head == null || head.next == null){
                return;
            }
            ListNode headFirst = head;
            ListNode mid = middleNode(head);
            ListNode headSecond = reverseList(mid);

            while(headFirst != null && headSecond != null){
                ListNode temp = headFirst.next;
                headFirst.next = headSecond;
                headFirst = temp;
                temp = headSecond.next;
                headSecond.next = headFirst;
                headSecond = temp;
            }

            if(headFirst != null){
                headFirst.next = null;
            }
        }
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
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
