class Solution 
{
    public int shipWithinDays(int[] weights, int days) 
    {
        int mincap = 0, maxcap = 0;
        for(int w: weights)
        {
            mincap = Math.max(mincap , w);
            maxcap += w;
        }
        while (mincap < maxcap) 
        {
            int mid = (mincap + maxcap) / 2;
            int need = 1, cur = 0;
            for (int w: weights) 
            {
                if (cur + w > mid) 
                {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            
            if (need > days) 
                mincap = mid + 1;
            
            else 
                maxcap = mid;
        }
        
        return mincap;
    }
}