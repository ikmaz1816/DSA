package stackimplementationproblem;

import java.util.HashMap;

class DllNode
{
    int key;
    int value;
    int frequency;
    DllNode next,prev;
    public DllNode(int key,int value,int frequency)
    {
        this.key=key;
        this.value=value;
        this.frequency=frequency;
    }
}
class DoubleLinkedList
{
    int size;
	DllNode head;
	DllNode tail;
    public DoubleLinkedList() {
	    head=new DllNode(0,0,0);
	    tail=new DllNode(0,0,0);
	    head.next=tail;
	    tail.prev=head;
	}
    public void insertNode(DllNode node){
	    node.next = head.next;
	    node.prev=head;
	    node.next.prev=node;
	    head.next=node;
        size++;
	}

    public void deleteNode(DllNode node){
	    node.next.prev=node.prev;
	    node.prev.next=node.next;
	    node.prev=null;
	    node.next=null;
        size--;
	}

    public int size()
    {
        return this.size;
    }
}
public class LFUCache {
    private HashMap<Integer,DllNode> map;
    private HashMap<Integer,DoubleLinkedList> freq;
    private int size;
    private int min;
    private final int FINAL_CAPACITY;
    public LFUCache(int capacity) {
        map=new HashMap<>();
        freq=new HashMap<>();
        size=0;
        min=0;
        FINAL_CAPACITY=capacity;
    }
    
    public int get(int key) {
       int value=-1;
       
       if(map.containsKey(key))
        {
            DllNode node = map.get(key);
            update(node);
            value=node.value;
        }
       return value;
    }

    public void update(DllNode node)
    {
        DoubleLinkedList list = freq.get(node.frequency);

        list.deleteNode(node);
        map.remove(node.key);
        
        if(node.frequency==min && list.size()==0)
        {
            freq.remove(min);
            min++;
        }
        node.frequency=node.frequency+1;
        list = freq.getOrDefault(node.frequency,new DoubleLinkedList());
        list.insertNode(node);
        freq.put(node.frequency,list);
        map.put(node.key,node);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            DllNode node = map.get(key);
            node.value=value;
            update(node);
        }
        else 
        {
            if(size==FINAL_CAPACITY)
            {
                DoubleLinkedList dll = freq.get(min);
                map.remove(dll.tail.prev.key);
                dll.deleteNode(dll.tail.prev);
                size--;
                
            }
            min = 1;
            DoubleLinkedList dll = freq.getOrDefault(min, new DoubleLinkedList());
            DllNode node = new DllNode(key,value,min);
            dll.insertNode(node);
            size++;
            map.put(key,node);
            freq.put(min,dll);
        }
    }
}