package llmediumproblem;

import linkedlistimplementation.Node;

public class Sort012LL {
	static Node segregate(Node head) {
        int countOne=0,countTwo=0,countZero=0;
        Node temp = head; 
        while(temp!=null)
        {
            if(temp.data==0)
                countZero++;
            else if(temp.data==1)
                countOne++;
            else
                countTwo++;
            temp = temp.next;
        }
        
        temp = head;
        while(countZero>0)
        {
            temp.data=0;
            temp=temp.next;
            countZero--;
        }
        
        while(countOne>0)
        {
            temp.data=1;
            temp=temp.next;
            countOne--;
        }
        
        while(countTwo>0)
        {
            temp.data=2;
            temp=temp.next;
            countTwo--;
        }
        
        return head;
    }
}
