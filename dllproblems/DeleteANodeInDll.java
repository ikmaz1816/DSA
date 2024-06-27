package dllproblems;

import linkedlistimplementation.DNode;

public class DeleteANodeInDll {
	//DNode is present in DLL implementation
	public DNode getDNode(DNode head,int pos)
    {
        DNode temp =head;
        //As number given is one-indexed based
        for(int i=0;i<pos-2;i++)
        {
            temp = temp.next;
        }
        return temp;
    }
    public DNode deleteNode(DNode head, int x) {
        DNode temp = getDNode(head,x);
        if(x==1)
        {
            head=head.next;
        }
        else
        {
            DNode temp1 = temp.next;
            temp.next = temp.next.next;
            if(temp.next!=null)
                temp.next.prev= temp;
            temp1.next=null;
            temp1.prev=null;
        }
        return head;
    }
}
