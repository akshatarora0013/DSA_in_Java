package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/add-two-numbers/

public class _2_Add_Two_Numbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int add = 0;
            add = add + l1.val + l2.val;
            ListNode ans = new ListNode(add%10);
            add = add/10;
            l1 = l1.next;
            l2 = l2.next;
            ListNode temp = ans;
            while(l1 != null && l2 != null){
                add = add + l1.val + l2.val;
                ListNode newNode = new ListNode(add%10);
                temp.next = newNode;
                temp = newNode;
                add = add/10;
                l1 = l1.next;
                l2 = l2.next;
            }
            while(l1 != null){
                add = add + l1.val;
                ListNode newNode = new ListNode(add%10);
                temp.next = newNode;
                temp = newNode;
                add = add/10;
                l1 = l1.next;
            }
            while(l2 != null){
                add = add + l2.val;
                ListNode newNode = new ListNode(add%10);
                temp.next = newNode;
                temp = newNode;
                add = add/10;
                l2 = l2.next;
            }
            while(add != 0){
                ListNode newNode = new ListNode(add%10);
                temp.next = newNode;
                temp = newNode;
                add = add/10;
            }
            return ans;
        }
    }
}
