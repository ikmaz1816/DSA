package stackqueueimplementation;

import java.util.Stack;

public class ImplementQueueUsingStack {
	private Stack<Integer> s1;
	private Stack<Integer> s2;
	
	public ImplementQueueUsingStack()
	{
		s1=new Stack<>();
		s2=new Stack<>();
	}
	
	public int size()
	{
		return this.s1.size();
	}
	
	public void offer(int x) {
        while(!s1.isEmpty())
        {
        	s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.isEmpty())
        {
        	s1.push(s2.pop());
        }
    }
    
    public int poll() {
    	return s1.isEmpty() ? -1 : s1.pop();
    }
    
    public int top() {
        return s1.isEmpty() ? -1 : s1.peek();
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public static void main(String[] args) {
    	ImplementQueueUsingStack q=new ImplementQueueUsingStack();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);
		while(!q.isEmpty())
		{
			System.out.print(q.poll()+" ");
		}
	}
}
