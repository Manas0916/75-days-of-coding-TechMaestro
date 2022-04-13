/**
 * Definition for singly-linked list.
 * public class ListNode {
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        int len1 = 0 , len2 = 0;
        ListNode curr = headA;
        while(curr != null)
        {
            len1++;
            curr = curr.next;
        }
        curr = headB;
        while(curr != null)
        {
            len2++;
            curr = curr.next;
        }
        ListNode l1 = headA , l2 = headB;
        if(len1 > len2)
        {
            for(int i = 1; i <= (len1 - len2); i++)
                l1 = l1.next;
        }
        else 
        {
            for(int i = 1; i <= (len2 - len1); i++)
                l2 = l2.next;
        }
        while(l1 != null && l2 != null)
        {
            if(l1 == l2)
                break;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == l2 ?  l1 : null;
    }
}