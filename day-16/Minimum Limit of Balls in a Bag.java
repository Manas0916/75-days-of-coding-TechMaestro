class Solution 
{
    public int minimumSize(int[] nums, int maxOperations) 
    {
        
        int left = 1, right = 1000000000;
        for(int i : nums)
            right = Math.max(right , i);
        
        while (left < right) 
        {
            int mid = (left + right) / 2, count = 0;
            
            for (int a : nums)
                count += (a - 1) / mid;
            
            if (count > maxOperations)
                left = mid + 1;
            
            else
                right = mid;
        }
        
        return left;
  
    }
}