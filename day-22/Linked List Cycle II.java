/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public ListNode detectCycle(ListNode head) 
    {
        ListNode slow=head,fast=head;
        boolean f=false;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast)
            {
                f= true;
                break;
            }     
        }
       if(f)
       {
           int c=0;
           slow=head;
           while(slow!=fast)
           {
               c++;
               slow=slow.next;
               fast=fast.next;
           }
           return slow;
       }
        else
            return null;
    }
}