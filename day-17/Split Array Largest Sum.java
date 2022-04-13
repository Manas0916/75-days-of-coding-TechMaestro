class Solution 
{
    public int splitArray(int[] nums, int m) 
    {
        int min = 0 , max = 0;
        
        for(int i : nums)
        {
            min = Math.max(min , i);
            max += i;
        }
        
        while(min < max)
        {
            int mid = min + (max - min) / 2;
            int count = 1 , curr = 0;
            for(int i : nums)
            {
                if(curr + i > mid)
                {
                    count++;
                    curr = 0;
                }
                curr += i;
            }
            if(count > m)
                min = mid + 1;
            else 
                max = mid;
        }
        return min;
    }
}