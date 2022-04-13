class Solution 
{
    public int divide(int dividend, int divisor) 
    {
        if(divisor == 1)
            return dividend;
        
        int c = 0;
        boolean flag = false;
        
        if(dividend == Integer.MIN_VALUE ) 
        {
            if(divisor == -1)
                return Integer.MAX_VALUE;
            
            if(divisor > 0)
               dividend += divisor;
            
            else 
                dividend -= divisor;
            
            c++;
        }
       
        
        if(( dividend < 0 && divisor > 0) || ( dividend > 0 && divisor < 0))
            flag = true;
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        while(dividend > 0) 
        {
            dividend -= divisor;
            c++;
        }
        if(dividend != 0) 
            c--;
        
        if(flag == false)
        return c;
        
        else 
            return -c;
    }
}