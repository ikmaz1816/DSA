package dllproblems;

import linkedlistimplementation.DNode;

public class ReverseADLL {
	//DNode is present in DLL implementation
	public static DNode reverseDLL(DNode  head)
	{
	    if(head==null || head.next==null)
	        return head;
	    DNode prev=null,current=head;
	    DNode next = current.next;
	    while(current!=null)
	    {
	        current.next=prev;
	        current.prev=next;
	        prev=current;
	        current=next;
	        if(next!=null)
	            next=next.next;
	    }
	    return prev;
	}	
}
