package llmediumproblem;

public class DeleteNodeFromBackOfList {
	public int size(ListNode head)
    {   
        ListNode temp =head;
        int size=0;
        while(temp!=null)
        {
            temp=temp.next;
            size++;
        }
        return size;
    }
    public ListNode getNode(ListNode head,int size)
    {
        ListNode temp = head;
        size-=1;
        while(size>0)
        {
            temp=temp.next;
            size--;
        }
        return temp;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head);
        int index = size-n;
        if(index==0)
        {
            head= head.next;
        }
        else
        {
            ListNode prevNodeOfTargetNode = getNode(head,size-n);
            if(prevNodeOfTargetNode!=null && prevNodeOfTargetNode.next!=null)
            {
                prevNodeOfTargetNode.next=prevNodeOfTargetNode.next.next;
            }
        }
        return head;
    }
}
