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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null)
            return head;
        ListNode curr1 = head;
        int c = 0;
        while(curr1 != null)
        {
            c++;
            curr1 = curr1.next;
        }
        k = k % c;
        for(int i = 1; i <=k; i++)
        {
            ListNode curr = head , prev = head;
            while(curr.next != null)
            {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            curr.next = head;
            head = curr;
        }
        return head;
    }
}