package llproblems;

class ListNode 
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
public class DeleteNodeWithoutHeadGiven {
	public void deleteNode(ListNode node) {
        ListNode prev=null;
        while(node.next!=null)
        {
            prev=node;
            node.val=node.next.val;
            node = node.next;
        }
        prev.next=null;
    }
}
