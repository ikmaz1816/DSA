package stackqueueimplementation;

import java.util.Stack;

public class MinStack {
	private Stack<Long> s;
    private Long min;
    public MinStack() {
        s=new Stack<>();
        min=Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long value = (long)val;
        if(s.isEmpty())
        {
            min=value;
            s.push(value);
        }
        else
        {
            if(value<min)
            {
                s.push(2*value-min);
                min=value;
            }
            else 
                s.push(value);
        }
    }
    
    public void pop() {
        if(s.isEmpty())
            return;
        long peek=s.pop();
        if(peek<min)
        {
            min = 2 * min - peek;
        }
    }

    
    public int top() {
        if(s.isEmpty())
            return -1;
        Long peek = s.peek();
        return peek>min ? peek.intValue() : min.intValue();
    }
    
    public int getMin() {
        if(s.isEmpty())
            return -1;
        return min.intValue();
    }
}
