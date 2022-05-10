class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = 0;
        
        int omax = 1, max = 0;
        for(int i = 0; i < n; i++)
        {
            max = 0;
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                    max = Math.max(max, dp[j]);
            }
            
            dp[i] = max + 1;
            omax = Math.max(omax , dp[i]);
        }
        return omax;
    }
}