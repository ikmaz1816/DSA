package stackqueueimplementation;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementationUsingOneQueue {
	private Queue<Integer> q1;
	
	public StackImplementationUsingOneQueue()
	{
		q1=new LinkedList<>();
	}
	
	public int size()
	{
		return this.q1.size();
	}
	
	public void push(int x) {
		int size = q1.size();
		q1.offer(x);
        while(size>0)
        {
        	q1.offer(q1.poll());
        	size--;
        }
    }
    
    public int pop() {
    	return q1.isEmpty() ? -1 : q1.poll();
    }
    
    public int top() {
        return q1.isEmpty() ? -1 : q1.peek();
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public static void main(String[] args) {
    	StackImplementationUsingOneQueue s=new StackImplementationUsingOneQueue();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
//		System.out.println(s);
		while(!s.isEmpty())
		{
			System.out.print(s.pop()+" ");
		}
	}
}
