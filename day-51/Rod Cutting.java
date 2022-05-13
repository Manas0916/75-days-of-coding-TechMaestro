class Solution
{
    public int cutRod(int price[], int n) 
    {
        int len[] = new int[n];
        for(int i = 0; i < n; i++)
        len[i] = i+1;
        
        int l = price.length;
        int dp[][] = new int[l+1][n+1];
        for(int i = 0; i <= l; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(i == 0 || j == 0)
                dp[i][j] = 0;
            }
        }
        for(int i = 1; i <= l; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(len[i-1] <= j)
                dp[i][j] = Math.max(price[i-1] + dp[i][j-len[i-1]] , dp[i-1][j]);
                
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        return dp[l][n];
    }
}