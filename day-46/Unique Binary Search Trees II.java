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
    public List<TreeNode> generateTrees(int n) 
    {
        return helper(1 , n);
    }
    public List<TreeNode> helper(int start , int end)
    {
        List<TreeNode> res = new ArrayList<>();
        if(start > end)
        {
            res.add(null);
            return res;
        }
        if(start == end)
        {
            res.add(new TreeNode(start));
            return res;
        }
        for(int i = start; i <= end; i++)
        {
            List<TreeNode> left = helper(start , i - 1);
            List<TreeNode> right = helper(i + 1 , end);
            for(TreeNode lt: left)
            {
                for(TreeNode rt : right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    res.add(root);
                }
            }
        }
        return res;
    }
}