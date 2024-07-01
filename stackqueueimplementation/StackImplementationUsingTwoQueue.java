package stackqueueimplementation;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementationUsingTwoQueue {
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	
	public StackImplementationUsingTwoQueue()
	{
		q1=new LinkedList<>();
		q2=new LinkedList<>();
	}
	
	public int size()
	{
		return this.q1.size();
	}
	
	public void push(int x) {
        while(!q1.isEmpty())
        {
        	q2.offer(q1.poll());
        }
        q1.add(x);
        while(!q2.isEmpty())
        {
        	q1.offer(q2.poll());
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
    	StackImplementationUsingTwoQueue s=new StackImplementationUsingTwoQueue();
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
