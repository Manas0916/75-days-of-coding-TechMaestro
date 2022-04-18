class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length , i;
        int res[] = new int[n - k + 1];
        
        int index = 0;
        for(i = 0; i < n; i++)
        {
            
            while( !dq.isEmpty() && dq.peek() < (i - k + 1) )
                dq.removeFirst();
            
            while( !dq.isEmpty() && nums[i] > nums[dq.peekLast()] )
                dq.removeLast();
            
            dq.addLast(i);
            
            if(i >= k - 1)
                res[index++] = nums[dq.peek()];
            
        }
       
        return res;
    }
}