class Solution 
{
    public int shortestSubarray(int[] nums, int k) 
    {
        int n = nums.length;
        long[] p = new long[n+1];
        
        for(int i = 0; i < n; ++i)
            p[i+1] = p[i] + (long)nums[i];
        
        int ans = n+1;
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i = 0; i < p.length; ++i)
        {
            while(!dq.isEmpty() && p[i] <= p[dq.getLast()])
                dq.removeLast();
            
            while(!dq.isEmpty() && p[i] >= p[dq.getFirst()] + k)
                ans = Math.min(ans , i - dq.removeFirst());
            
            dq.addLast(i);
        }
        
        return ans < n+1 ? ans : -1;
            
    }
}