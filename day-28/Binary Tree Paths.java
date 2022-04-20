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
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> res = new ArrayList<String>();
        if(root == null)
            return res;
        
        String s = "";
        dfs(root, res, s);
        
        return res;
    }
    public void dfs(TreeNode root, List<String> res, String s)
    {
        if(root.left == null && root.right == null)
        {
            s += root.val;
            res.add(s);
            return;
        }
        if(root.left != null)
        {
            String prev = s;
            s += root.val + "->";
            dfs(root.left, res, s);
            s = prev;
        }
        if(root.right != null)
        {
            s += root.val + "->";
            dfs(root.right, res, s);
        }
    }
}