package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/add-two-numbers-ii/description/

public class _445_Add_Two_Numbers_II {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode one = reverseList(l1);
            ListNode second = reverseList(l2);
            ListNode head = new ListNode(-1);
            ListNode itr = head;
            int carry = 0;
            while(one != null || second != null || carry != 0){
                int sum = carry;
                if(one != null){
                    sum += one.val;
                }
                if(second != null){
                    sum += second.val;
                }
                int digit = sum % 10;
                carry = sum/10;
                itr.next = new ListNode(digit);
                itr = itr.next;

                if(one != null){
                    one = one.next;
                }
                if(second != null){
                    second = second.next;
                }
            }
            return reverseList(head.next);
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
