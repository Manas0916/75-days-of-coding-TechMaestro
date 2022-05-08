class Solution 
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        backtrack(res , new ArrayList<>() , candidates , target , 0);
        
        return res;
    }
     public void backtrack(List<List<Integer>>res, List<Integer> ds, int[] nums, int target, int ind)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind; i < nums.length; i++)
        {
            if(i > ind && nums[i] == nums[i - 1])
                continue;
            
            if(nums[i] > target)
                break;

            ds.add(nums[i]);
            backtrack(res , ds , nums , target - nums[i] , i + 1);
            ds.remove(ds.size() - 1);
        }
    }
}