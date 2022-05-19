class Solution
{
    void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int vis[])
    {
        vis[node] = 1;
        for(int it : adj.get(node))
        {
            if(vis[it] == 0)
            dfs(it, st, adj, vis);
        }
        st.push(node);
    }
    void revdfs(int node, ArrayList<ArrayList<Integer>> trans , int vis[])
    {
        vis[node] = 1;
        for(int it : trans.get(node))
        {
            if(vis[it] == 0)
            revdfs(it, trans , vis);
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(vis[i] == 0)
            dfs(i, st, adj, vis);
        }
        ArrayList<ArrayList<Integer>> trans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) 
        {
           trans.add(new ArrayList<>());
       }
        for(int i=0;i<V;i++)
        {
            vis[i] =0;
            for(int it: adj.get(i))
            trans.get(it).add(i);
        }
        int c=0;
        while(st.size() > 0)
        {
            int node = st.pop();
            if(vis[node] == 0)
            {
                c++;
                revdfs(node,trans, vis);
            }
        }
        return c;
    }
}
