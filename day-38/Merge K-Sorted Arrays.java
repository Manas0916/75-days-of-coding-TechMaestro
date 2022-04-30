class Solution
{
    static class Triplet implements Comparable<Triplet>
    {
        int val,aPos,vPos;
        Triplet(int v , int a , int vp)
        {
            this.val=v; this.aPos=a; this.vPos=vp;
        }
        public int compareTo(Triplet t)
        {
            if(val <= t.val)
                return -1;
            else
                return 1;
        }
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> res= new ArrayList<>();
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
            pq.add(new Triplet(arr[i][0],i,0));
            
        while(!pq.isEmpty())
        {
            Triplet curr= pq.poll();
            res.add(curr.val);
            int ap=curr.aPos,vp=curr.vPos;
            if(vp+1 < arr[ap].length)
            pq.add(new Triplet(arr[ap][vp+1],ap,vp+1));
        }
        return res;
    }
}