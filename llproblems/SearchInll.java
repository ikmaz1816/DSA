package llproblems;

public class SearchInll {
	static boolean searchKey(int n, Node head, int key) {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data==key)
                return true;
            temp = temp.next;
        }
        return false;
    }
}
