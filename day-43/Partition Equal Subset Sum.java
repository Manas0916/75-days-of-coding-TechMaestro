
class Solution
{
    static boolean subset(int n , int sum, int a[])
    {
        boolean dp[][] = new boolean[n + 1][sum + 1];
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
            for(int j = 0; j <= sum; j++)
            {
                if(a[i - 1] <= j)
                dp[i][j] = dp[i - 1][j - a[i - 1]] || dp[i - 1][j];
                
                else 
                dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }
    static int equalPartition(int N, int arr[])
    {
        int sum = 0; boolean res = false;;
        for(int i : arr)
        sum += i;
        
        if(sum % 2 != 0)
        return 0;
        
        else if(sum % 2 == 0)
        res = subset(N , sum / 2 , arr);
        
        return res == true ? 1 : 0;
    }
}