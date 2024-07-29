package heapsmedium;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeMSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = null,tail=null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<>()
        {
            public int compare(ListNode x,ListNode y)
            {
                return x.val-y.val;
            }
        });
        for(int i=0;i<lists.length;i++)
        {
        	if(lists[i]!=null)
                pq.add(lists[i]);
        }
        while(!pq.isEmpty())
        {
            ListNode p=pq.poll();
            if(head==null)
            {
            	head=p;
            	tail=p;
            }
            else
            {
            	tail.next=p;
            	tail=tail.next;
            }
            if(p.next!=null)
            {
                pq.add(p.next);
            }
        }
        return head;
    }
}
