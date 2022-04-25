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
class Solution 
{
    public void flatten(TreeNode root) 
    {
        if(root == null)
            return;
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null || !st.isEmpty())
        {
            while(curr != null)
            {
                if(curr.right != null)
                {
                    st.push(curr.right);
                    if(curr.left != null)
                    {
                        curr.right = curr.left;
                        curr.left = null;
                        curr = curr.right;
                    }
                    else 
                    {
                        curr.right = st.isEmpty() ? null : st.pop();
                        curr = curr.right;
                    }
                        
                }
                else if(curr.left != null && curr.right == null)
                {
                    curr.right = curr.left;
                    curr.left = null;
                    curr = curr.right;
                }
                else
                {
                    curr.right = curr.right = st.isEmpty() ? null : st.pop();
                    curr = curr.right;
                }
                
            }
        }
    }
}