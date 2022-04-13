class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int first = -1 , last = -1 , n = nums.length;
        
        int l = 0 , h = n -1;
        while(l <= h)
        {
            int m = (l + h) / 2;
            if(nums[m] == target)
            {
                first = m;
                h = m - 1; 
            }
            else if(nums[m] < target)
                l = m + 1;
            
            else 
                h = m - 1;      
        }
        
        l = 0; h = n -1;
        while(l <= h)
        {
            int m = (l + h) / 2;
            if(nums[m] == target)
            {
                last = m;
                l = m + 1; 
            }
            else if(nums[m] < target)
                l = m + 1;
            
            else 
                h = m - 1;      
        }
        return new int[]{first, last};
    }
}