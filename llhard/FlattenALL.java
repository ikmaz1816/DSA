package llhard;

class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
public class FlattenALL {
	Node merge(Node head,Node mid)
    {
        Node temp = new Node(-1);
        Node tail=temp;
        while(head!=null && mid!=null)
        {
            if(head.data>mid.data)
            {
                tail.bottom=mid;
                tail=tail.bottom;
                mid=mid.bottom;
            }
            else
            {
                tail.bottom=head;
                tail=tail.bottom;
                head=head.bottom;
            }
        }
        while(head!=null)
        {
            tail.bottom=head;
            tail=tail.bottom;
            head=head.bottom;
        }
        while(mid!=null)
        {
            tail.bottom=mid;
            tail=tail.bottom;
            mid=mid.bottom;
        }
        return temp.bottom;
    }
    Node flatten(Node root) {
        if(root==null || root.next==null)
            return root;
        flatten(root.next);
        return merge(root,root.next);
    }
}
