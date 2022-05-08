class Solution 
{
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans , new ArrayList<Integer>(), 1, n , k);
        return ans;
    }
    public void solve(List<List<Integer>> ans, List<Integer> ds,int id, int n,int k)
    {
        if(k == 0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = id; i <= n; i++)
        {
            ds.add(i);
            solve(ans , ds , i + 1, n , k - 1);
            ds.remove(ds.size() - 1);
        }
    }
}