class Solution
{
    static class pair
    {
        int s , e;
        pair(int _s , int _e)
        {
            this.s = _s;
            this.e = _e;
        }
    }
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        ArrayList<pair> al = new ArrayList<>();
        for(int i = 0; i < n; i++)
        al.add(new pair(start[i] ,  end[i]));
        
        Collections.sort(al , (a, b)->(a.e - b.e));
        int res = 1, prev = 0;
        for(int  i = 0; i < n; i++)
        {
            if(al.get(i).s > al.get(prev).e)
            {
                res++;
                prev = i;
            }
        }
        
        return res;
    }
}