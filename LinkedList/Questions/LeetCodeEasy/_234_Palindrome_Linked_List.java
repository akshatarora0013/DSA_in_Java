package LinkedList.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/palindrome-linked-list/

public class _234_Palindrome_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode mid = middleNode(head);
            ListNode headSecond = reverseList(mid);
            while(head != null && headSecond != null){
                if(head.val != headSecond.val){
                    return false;
                }
                head = head.next;
                headSecond = headSecond.next;
            }
            return true;
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
