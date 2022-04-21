/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode r, TreeNode p, TreeNode q) 
    {
        if(r == null)
            return null;
        
        if(r.val == p.val || r.val == q.val)
            return r;
        
        TreeNode lca1 = lowestCommonAncestor(r.left , p , q);
        TreeNode lca2 = lowestCommonAncestor(r.right , p , q);
        
        if(lca1 != null && lca2 != null)
            return r;
        
        return (lca1 != null) ? lca1 : lca2;
    }
}