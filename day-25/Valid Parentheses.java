class Solution 
{
    boolean check(char a , char b)
    {
return (a == '(' && b == ')') || (a == '{' && b == '}' || (a == '[' && b == ']' ));
    }
    
    public boolean isValid(String s) 
    {
        Stack<Character> st = new Stack<>();
        char ch;
        
        for(int i = 0; i < s.length(); i++)
        {
            ch = s.charAt(i);
            
            if(ch =='{' || ch == '[' || ch == '(')
                st.push(ch);
            
            else 
            {
                if(st.isEmpty()) 
                    return false;
                
                else if( check(st.peek() , ch) == false )
                    return false;
                
                else 
                    st.pop();
            }
        }
        return st.isEmpty();
    }
}