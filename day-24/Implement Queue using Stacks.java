class MyQueue 
{
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() 
    {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) 
    {
        s1.push(x);
    }
    
    public int pop() 
    {
        if(s2.isEmpty())
        {
            if(s1.isEmpty())
                return -1;
            
            while(!s1.isEmpty())
            {
                int r1 = s1.peek();
                s1.pop();
                s2.push(r1);
            }
            int k = s2.peek();
            s2.pop();
            
            while(!s2.isEmpty())
            {
                int l = s2.peek();
                s2.pop();
                s1.push(l);
            }
            
            return k;
        }
       return -1;
    }
    
    public int peek() 
    {
        while(!s1.isEmpty())
        {
            int r = s1.peek();
            s1.pop();
            s2.push(r);
        }
        int k = s2.peek();
        
        while(!s2.isEmpty())
        {
            int l = s2.peek();
            s2.pop();
            s1.push(l);
        }
        return k;
    }
    
    public boolean empty() 
    {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */