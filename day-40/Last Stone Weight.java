class Solution 
{
    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int n = stones.length;
        
        for(int i = n - 1; i >= 0; i--)
            pq.add(stones[i]);
        
        while(pq.size() > 1)
        {
            int y = pq.poll();
            int x = pq.isEmpty() ? 0 : pq.poll();
            if(x == y)
                pq.add(0);
            else if(x != y)
                pq.add(y - x);
        }
        
        return pq.poll();
    }
}