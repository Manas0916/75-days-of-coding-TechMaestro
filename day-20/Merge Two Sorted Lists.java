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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        if(l1 == null) 
            return l2;
        if(l2 == null) 
            return l1;
        
        ListNode res = new ListNode(0);
        ListNode curr = res;
       
        while(true)
        {
            if(l1 == null) 
            {
                curr.next = l2;
                break;
            }
            if(l2 == null)
            {
                curr.next = l1;
                break;
            }
           
            if(l1.val <= l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else 
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
       return res.next;
    }
}