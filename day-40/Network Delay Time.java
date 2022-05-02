class Solution 
{
    int[] dist;
    Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
    
    class Pair 
    {
        int node, dist;
        public Pair(int node, int dist) 
        {
            this.dist = dist;
            this.node = node;
        }
    }
    public int dijkstra(int k) 
    {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        pq.add(new Pair(k, 0));
        
        while(pq.isEmpty() == false) 
        {
            Pair curr = pq.poll();
            ArrayList<int[]> children = adj.get(curr.node);
            if(children != null) 
            {
                for(int[] child: children) 
                {
                    int d = curr.dist + child[1];
                    if(d < dist[child[0]]) 
                    {
                        dist[child[0]] = d;
                        pq.add(new Pair(child[0], d));
                    }
                }
            }
        }
        
        int max = -1;
        for(int i = 1; i < dist.length; i++) 
        {
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            
            max = Math.max(max, dist[i]);
        }
        
        return max;
    }
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        
        dist = new int[n+1];
        for(int i = 0; i < times.length; i++) 
        {
            int a = times[i][0];
            int b = times[i][1];
            int wt = times[i][2];
            if(!adj.containsKey(a)) 
                adj.put(a, new ArrayList<int[]>());
            
            adj.get(a).add(new int[]{b, wt});
        }
        
        return dijkstra(k);
    }
}