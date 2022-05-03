class Solution
{
    static List<Integer> minPartition(int N)
    {
        List<Integer> al = new ArrayList<>();
        int deno[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int n = 10;
        
        for(int i = n - 1; i >= 0; i--)
        {
            while(N >= deno[i])
            {
                N -= deno[i];
                al.add(deno[i]);
            }
        }
        return al;
    }
}