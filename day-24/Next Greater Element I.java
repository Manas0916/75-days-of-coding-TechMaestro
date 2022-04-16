class Solution 
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int res[] = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = n-1; i >= 0; i--)
        {      
            
            while(!st.isEmpty() && st.peek() < nums2[i])
                st.pop();
            
            if(!st.isEmpty())
                map.put(nums2[i] , st.peek());
            
            else
                map.put(nums2[i] , -1);
            
            st.push(nums2[i]);            
        }
        
        int i=0;        
        for(int num : nums1)
            res[i++] = map.getOrDefault(num, -1);
        
        return res;
    }
}