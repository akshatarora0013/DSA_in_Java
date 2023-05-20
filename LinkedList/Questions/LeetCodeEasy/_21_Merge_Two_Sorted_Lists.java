package LinkedList.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/merge-two-sorted-lists/

public class _21_Merge_Two_Sorted_Lists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode first, ListNode second) {
            ListNode ans = new ListNode();
            ListNode temp = ans;
            while(first != null && second != null){
                if(first.val <= second.val){
                    temp.next = first;
                    first = first.next;
                    temp = temp.next;
                }
                else{
                    temp.next = second;
                    second = second.next;
                    temp = temp.next;
                }
            }
            while(first != null){
                temp.next = first;
                first = first.next;
                temp = temp.next;
            }
            while(second != null){
                temp.next = second;
                second = second.next;
                temp = temp.next;
            }
            return ans.next;
        }
    }
}
