package stackimplementationproblem;

import java.util.Stack;

class Pair
{
    int data;
    int count;
    public Pair(int data,int count)
    {
        this.data=data;
        this.count=count;
    }
}
public class LeetcodeStockSpan {
	Stack<Pair> st;
    public LeetcodeStockSpan() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!st.isEmpty() && price>=st.peek().data)
        {
           Pair p = st.pop();
           span += p.count;
        }
        
        st.push(new Pair(price,span));
        return span;
    }
}
