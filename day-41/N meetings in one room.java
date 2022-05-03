
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
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<pair> al = new ArrayList<>();
        for(int i = 0; i < n; i++)
            al.add(new pair(start[i] , end[i]));
            
        Collections.sort(al , (a, b)->(a.e - b.e));
        
        int res = 1 , prev = 0;
        for(int curr = 1; curr < n; curr++)
        {
            if(al.get(curr).s > al.get(prev).e)
            {
                res++;
                prev = curr;
            }
        }
        
        return res;
    }
}
