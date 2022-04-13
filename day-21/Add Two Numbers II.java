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
    public ListNode add(ListNode l1, ListNode l2) 
    {
        int s = 0 , carry = 0;
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(l1 != null || l2 != null)
        {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            s = (x + y) + carry;
            carry = s / 10;
            res.next = new ListNode(s % 10);
            
            if(l1 != null)
            l1 = l1.next;
            
            if(l2 != null)
            l2 = l2.next;
            
            res = res.next;
        }
        if(carry > 0)
            res.next = new ListNode(carry);
        
        return head.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode revl1 = reverse(l1);
        ListNode revl2 = reverse(l2);
        ListNode res = add(revl1 , revl2);
        res = reverse(res);
        
        return res;
    }
}