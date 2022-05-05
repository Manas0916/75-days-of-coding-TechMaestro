class itemComparator implements Comparator<Item>
{
    //comparison function to sort items according to value/weight ratio.
    public int compare(Item a, Item b)
    {
        double r1 = (double)a.value / a.weight;
        double r2 = (double)b.value / b.weight;
        if(r1 > r2)
            return -1;
         else if(r1 < r2) 
            return 1;
            
        return 0;
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr, new itemComparator());
        
        int curWeight = 0;
        double finalvalue = 0.0;
        
        //iterating over all the items.
        for (int i = 0; i < n; i++) 
        {
            //if currweight + item's weight is less than or equal to W,
            //then we add the item's value to final value.
            if (curWeight + arr[i].weight <= W) 
            {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            } 
            else 
            {
                int remain = W - curWeight;
                finalvalue += arr[i].value * ((double) remain / arr[i].weight);
                break;
            }
        }
        return finalvalue;
    }
}