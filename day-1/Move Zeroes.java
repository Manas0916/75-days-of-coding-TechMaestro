class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        int l = 0 , n = nums.length;
        for(int i = 1; i < n ; i++)
        {
            if(nums[l] == 0 && nums[i] != 0)
            {
                int t = nums[i];
                nums[i] = nums[l];
                nums[l] = t;
                l++;
            }
            else if(nums[i] == 0 && nums[l] != 0)
                l++;
            
            else if(nums[i] != 0 && nums[l] != 0)
                l++;
        }
 
    }
}