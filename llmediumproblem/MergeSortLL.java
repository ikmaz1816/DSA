package llmediumproblem;

public class MergeSortLL {
	public ListNode getMid(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode mid = null;
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            mid=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        mid.next=null;
        return slow;
    }

    public ListNode merge(ListNode head,ListNode mid)
    {
        ListNode temp=new ListNode(-1);
        ListNode tail=temp;
        while(head!=null && mid!=null)
        {
            if(head.val>mid.val)
            {
                tail.next=mid;
                tail=tail.next;
                mid = mid.next; 
            }
            else
            {
                tail.next=head;
                tail=tail.next;
                head = head.next;
            }
        }
        while(head!=null)
        {
            tail.next=head;
            tail=tail.next;
            head = head.next;
        }
        while(mid!=null)
        {
            tail.next=mid;
            tail=tail.next;
            mid = mid.next;
        }
        return temp.next;
    }

    public ListNode mergeSort(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode mid = getMid(head);
        ListNode first=mergeSort(head);
        ListNode second=mergeSort(mid);
        return merge(first,second);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}
