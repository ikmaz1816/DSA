package stackimplementationproblem;

import java.util.HashMap;

class Node
{
    int key;
    int value;
    Node prev,next;
    public Node(int key,int value)
    {
        this.key=key;
        this.value=value;
    }
}
public class LRUCache {
	 	private HashMap<Integer,Node> map;
	    private int size;
	    private Node head;
	    private Node tail;
	    private final int FINAL_CAPACITY;
	    public LRUCache(int capacity) {
	        map=new HashMap<>();
	        size=0;
	        head=new Node(0,0);
	        tail=new Node(0,0);
	        FINAL_CAPACITY=capacity;
	        head.next=tail;
	        tail.prev=head;
	    }
	    
	    public int get(int key) {
	        int value=-1;
	        if(map.containsKey(key))
	        {
	            Node node = map.get(key);
	            deleteNode(node);
	            insertNode(node);
	            value=node.value;
	        }
	        return value;
	    }

	    public void insertNode(Node node){
	        node.next = head.next;
	        node.prev=head;
	        node.next.prev=node;
	        head.next=node;
	        map.put(node.key,node);
	    }

	    public void deleteNode(Node node){
	        map.remove(node.key);
	        node.next.prev=node.prev;
	        node.prev.next=node.next;
	        node.prev=null;
	        node.next=null;
	    }
	    
	    public void put(int key, int value) {
	        if(map.containsKey(key))
	        {
	            Node node = map.get(key);
	            deleteNode(node);
	            insertNode(new Node(key,value));
	        }
	        else
	        {
	            if(size==FINAL_CAPACITY)
	            {
	                deleteNode(tail.prev);
	                size--;
	            }
	            insertNode(new Node(key,value));
	            size++;
	        }
	    }
}
