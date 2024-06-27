package dllproblems;

import linkedlistimplementation.DoublyLinkedList;
import linkedlistimplementation.DNode;
public class IntroductionToDLL {
	//DNode is present in DLL implementation
	 DNode constructDLL(int arr[]) {
	        DoublyLinkedList ll=new DoublyLinkedList();
	        for(int i:arr)
	        {
	            ll.addLast(i);
	        }
	        return ll.getHead();
	    }
}
