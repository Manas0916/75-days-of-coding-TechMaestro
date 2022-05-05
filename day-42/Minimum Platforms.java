class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        int i=1,j=0; int c=1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        while(i<n && j<n)
        {
            if(arr[i]<=dep[j])
            {
                c++; i++;
            }
            else
            {
                i++; j++;
            }
        }
        return c;
    }
    
}

