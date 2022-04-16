class Solution 
{
    public int[] plusOne(int[] digits) 
    {
        int n = digits.length , sum = 0 , carry = 0;
         digits[n-1] = digits[n-1] + 1;
        
        if(digits[n-1] <= 9)
            return digits;
        
        for(int i = n -1 ; i >= 0; i--)
        {
            sum = digits[i] + carry;
            if(sum > 9)
            {
                digits[i] = sum % 10; 
                carry = sum / 10;
            }
            else 
            {
                digits[i] = sum;
                return digits;
            }
                
        }
        if(carry != 0)
        {
            int[] ans = new int[n+1];
            ans[0] = carry;
            for(int i = 0; i < n; i ++)
                ans[i+1] = digits[i];
            
            return ans;
        }
        
        return digits;
    }
}