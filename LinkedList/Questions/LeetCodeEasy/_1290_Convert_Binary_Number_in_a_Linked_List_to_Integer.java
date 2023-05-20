package LinkedList.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/

public class _1290_Convert_Binary_Number_in_a_Linked_List_to_Integer {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public int getDecimalValue(ListNode head) {
            int num = 0;
            while(head != null){
                num = num * 2 + head.val;
                head = head.next;
            }
            return num;
        }
    }
}
