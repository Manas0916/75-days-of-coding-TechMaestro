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
    public ListNode getMid(ListNode lists[] , int s , int e)
    {
        if(s == e)
            return lists[s];
        int m = s + (e - s) / 2;
        ListNode left = getMid(lists , s , m);
        ListNode right = getMid(lists , m + 1 , e);
        
        return merge(left , right);
    }
    public ListNode merge(ListNode l1 , ListNode l2)
    {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        
        while(l1 != null || l2 != null)
        {
            if(l1 == null)
            {
                curr.next = l2;
                l2 = l2.next;
            }
            else if(l2 == null)
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else if(l1.val < l2.val)
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
        return result.next;
    }
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists == null || lists.length == 0)
            return null;
        return getMid(lists , 0 , lists.length-1);
    }
}