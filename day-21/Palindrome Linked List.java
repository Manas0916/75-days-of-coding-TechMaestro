/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode reverse(ListNode head) 
    {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) 
    {
        if(head == null)
            return true;
        
        ListNode slow = head , fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode rev = reverse(slow.next);
        
        ListNode curr = head;
        while(rev != null)
        {
            if(rev.val != curr.val)
                return false;
            rev = rev.next;
            curr = curr.next;
        }
        return true;
    }
}