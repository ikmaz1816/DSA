package dllhardproblems;

public class RemoveDuplicates {
	 Node removeDuplicates(Node head){
	        if(head==null || head.next==null) return head;
	        Node start=head;
	        Node end = head.next;
	        while(end!=null)
	        {
	            while(end!=null && start.data==end.data)
	            {
	                end=end.next;
	            }
	            start.next=end;
	            if(end!=null)
	                end.prev=start;
	            start=start.next;
	            
	        }
	        return head;
	        
	    }
}
