class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        char[] cnt = new char[26];
        int maxn = 0;
        
        for (int task : tasks) 
        {
            cnt[task - 'A'] ++;
            maxn = Math.max(maxn, cnt[task - 'A']);
        }
        
        int ans = (maxn - 1) * (n + 1);
        for (int i = 0; i < 26; i++)
            if (cnt[i] == maxn)
                ans ++;
        
        return Math.max(ans, tasks.length);
    }
}