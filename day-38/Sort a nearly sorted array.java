class Solution
{
    private static void kSort(int[] arr, int n, int k)
    {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < k + 1; i++) 
            priorityQueue.add(arr[i]);

 
        int index = 0;
        for (int i = k + 1; i < n; i++) 
        {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
 
        Iterator<Integer> itr = priorityQueue.iterator();
 
        while (itr.hasNext()) 
        {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }
}