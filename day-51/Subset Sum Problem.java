class Solution
{
    static Boolean isSubsetSum(int n, int arr[], int sum)
    {
        boolean dp[][] = new boolean[n+1][sum+1];
        
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= sum; j++)
            {
                if(i == 0)
                dp[i][j] = false;
                if(j == 0)
                dp[i][j] = true;
            }
        }
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= sum; j++)
            {
                if(arr[i-1] <= j)
                dp[i][j] = dp[i-1][j] | dp[i-1][j-arr[i-1]];
                else 
                dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}