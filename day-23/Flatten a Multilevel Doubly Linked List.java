/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution 
{
    public Node flatten(Node head) 
    {
        if(head == null)
            return null;
        
        Stack<Node> st = new Stack<Node>();
        Node curr = head;
        while(curr != null)
        {
            if(curr.child != null)
            {
                if(curr.next != null)
                st.push(curr.next);
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }

            if(curr.next == null && !st.isEmpty())
            {
                Node node = st.pop();
                curr.next = node;
                node.prev = curr;
            }
            
            curr = curr.next;
        }
        return head;
    }
}