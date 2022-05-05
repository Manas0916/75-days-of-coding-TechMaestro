class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr , (a , b)->(b.profit - a.profit));
        
         int res=0, count=0;
       
        int[] result = new int[n];
        
        boolean[] slot = new boolean[n];
        
        Arrays.fill(slot, false);
        for (int i=0; i<n; i++)
        {
            for (int j=Integer.min(n, arr[i].deadline)-1; j>=0; j--) 
            { 
                if (slot[j]==false)
                { 
			        result[j] = i; 
			        slot[j] = true;
			        break; 
		        } 
	        } 
	    } 
	    for (int i=0; i<n; i++)
	    {
	        
	        if(slot[i]) 
	        {
	            count++;
	            res += arr[result[i]].profit;
	        }
	    }
	   
	    int[] ans = new int[2];
	    ans[0] = count;
	    ans[1] = res;
	    return new int[]{count , res};
        
    }
}