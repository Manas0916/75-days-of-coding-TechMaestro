class Solution 
{
    public int[] nextGreaterElements(int[] nums) 
    {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[nums.length];
        int n = nums.length;
        
        
        for(int i = (2*n)-1; i >= 0; i--)
        {
            while(!st.isEmpty() && st.peek() <= nums[i % n])
                st.pop();
            
            if(i < n)
               res[i] = st.isEmpty() ? -1 : st.peek();
            
            st.push(nums[i % n]);
        }
        
        return res;
    }
}