class Solution
{
    static ArrayList<ArrayList<Integer>> result;
    static int[] row = new int[10];
    static int k = 0;
    
    static boolean place(int r,int c) 
    {
    	for(int prev = 0; prev < c; prev++)
    		if(row[prev] == r ||(int)Math.abs(row[prev] - r) == (int)Math.abs(prev - c))
    			return false;
    			
    	return true;
    }
    
    static void bt(int c,int n) 
    {
    	if(n == 2 || n == 3) 
    	    return;
    	if(c == n) 
    	{
    		
    		ArrayList<Integer> v = new ArrayList<Integer>();
    		
    		for(int i = 0;i < n;i++)
    		    v.add(row[i]+1);
    		result.add(v);
    		k++;
    	}
    	
    	for(int i = 0;i < n;i++) 
    	{
    		if(place(i, c)) 
    		{
    			row[c] = i;
    			bt(c+1, n);
    		}
    	}
    }
    static ArrayList<ArrayList<Integer>> nQueen(int n) 
    {
        result = new ArrayList<ArrayList<Integer>>();
        bt(0, n);
        return result;
    }
}