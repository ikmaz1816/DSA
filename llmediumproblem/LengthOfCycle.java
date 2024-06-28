package llmediumproblem;

import linkedlistimplementation.Node;

public class LengthOfCycle {
	 static int countNodesinLoop(Node head)
	    {
	        int count=0;
	        Node slow = head;
	        Node fast=head;
	        while(fast!=null && fast.next!=null)
	        {
	            fast=fast.next.next;
	            slow = slow.next;
	            if(slow==fast)
	            {
	                while(slow.next!=fast)
	                {
	                    slow=slow.next;
	                    count++;
	                }
	                 return count+1;
	            }
	           
	        }
	        return 0;
	    }
}
