package dllproblems;

import linkedlistimplementation.DNode;

public class InsertANodeInDLL {
	//DNode is present in DLL implementation
	public DNode getDNode(DNode head,int pos)
    {
        DNode temp =head;
        //as pos+1 hence iterated till pos
        for(int i=0;i<pos;i++)
        {
            temp = temp.next;
        }
        return temp;
    }
    //Function to insert a new DNode at given position in doubly linked list.
    void addDNode(DNode head, int pos, int data)
	{
    	// Here whatever is the position it is considered +1 gfg logic
			DNode newDNode = new DNode(data);
			DNode DNode = getDNode(head,pos);
			//checking for first position
// 			if(pos==0)
// 			{
// 			    newNode.next = head;
// 			    head.prev = newNode;
// 			    head = newNode;
// 			    return;
// 			}
			//checking for last position
			if(DNode.next==null)
			{
			    DNode.next = newDNode;
			    newDNode.prev=DNode;
	            return;
			}
			newDNode.next = DNode.next;
			newDNode.prev = DNode;
			DNode.next.prev=newDNode;
			DNode.next = newDNode;
	}
}
