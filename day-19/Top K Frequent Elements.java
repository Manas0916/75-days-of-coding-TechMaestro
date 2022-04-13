class Solution 
{
    class pair
    {
        int n , f;
        pair(int _n , int _f)
        {
            this.n = _n;
            this.f = _f;
        }
    }
    public int[] topKFrequent(int[] nums, int k) 
    {
        
        HashMap<Integer , Integer> hm = new LinkedHashMap<>();
        for(int i : nums)
            hm.put(i , hm.getOrDefault(i , 0)+1);
        
        PriorityQueue<pair> pq = new PriorityQueue<>((x , y)->(y.f - x.f));
        
        for(Map.Entry<Integer , Integer> e : hm.entrySet())
            pq.add(new pair(e.getKey() , e.getValue()));
        
        
        int a[] = new int[k];
        for(int i = 0; i < k; i++)
            a[i] = pq.poll().n;
        
        return a;
    }
}