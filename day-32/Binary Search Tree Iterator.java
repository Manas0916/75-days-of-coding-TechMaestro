/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator 
{
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) 
    {
        st = new Stack<>();
        TreeNode curr = root;
        while (curr != null) 
        {
            st.push(curr);
            curr = curr.left;
        }
    }
    
    public int next() 
    {
        TreeNode node = st.pop();
        
        TreeNode curr = node.right;
        while (curr != null)
        {
            st.push(curr);
            curr = curr.left;
        }
        return node.val;
    }
    
    public boolean hasNext() 
    {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */